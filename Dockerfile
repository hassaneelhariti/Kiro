# Use official Maven image with Java 21
FROM maven:3.9-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first (for better caching)
COPY pom.xml .

# Download dependencies (this layer will be cached)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Runtime stage - smaller image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Create logs directory (for your logging config)
RUN mkdir -p logs

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]