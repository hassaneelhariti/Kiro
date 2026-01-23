package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.service.productownerservice.EpicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EpicController {
    private EpicService epicService;

    @GetMapping("/epic")
    public ResponseEntity<List<EpicDto>> getAllEpics() {
        List<EpicDto> epicDtos = epicService.getAllEpics();
        return ResponseEntity.ok(epicDtos);
    }

    @GetMapping("/epic/{id}")
    public ResponseEntity<EpicDto> getEpic(@PathVariable Long id) {
        EpicDto epicDto = epicService.getEpic(id);
        return ResponseEntity.ok(epicDto);
    }

    @PostMapping("/epic")
    public ResponseEntity<EpicDto> createEpic(@Valid @RequestBody EpicDto epicDto) {
        EpicDto epicCreated = epicService.createEpic(epicDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(epicCreated);
    }

    @DeleteMapping("/epic/{id}")
    public ResponseEntity<Void> deleteEpic(@PathVariable Long id) {
        epicService.deleteEpic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}