package ma.ensa.kirobackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.EpicDto;
import ma.ensa.kirobackend.service.productownerservice.EpicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EpicController {
    private EpicService epicService;

    @GetMapping("/epic")
    public List<EpicDto> getAllEpics() {
        return epicService.getAllEpics();
    }

    @GetMapping("/epic/{id}")
    public EpicDto getEpic(@PathVariable Long id) {
        return epicService.getEpic(id);
    }

    @PostMapping("/epic")
    public EpicDto createEpic(@Valid @RequestBody EpicDto epicDto) {
        return epicService.createEpic(epicDto);
    }

    @DeleteMapping("/epic/{id}")
    public void deleteEpic(@PathVariable Long id) {
        epicService.deleteEpic(id);
    }
}