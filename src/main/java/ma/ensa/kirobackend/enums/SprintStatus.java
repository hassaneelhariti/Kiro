package ma.ensa.kirobackend.enums;

public enum SprintStatus {
    PLANNED,     // Created but not started
    ACTIVE,      // Running sprint (ONLY ONE ACTIVE per project)
    COMPLETED,   // Finished normally
    CANCELLED    // Cancelled by Product Owner
}
