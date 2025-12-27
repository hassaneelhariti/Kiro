package ma.ensa.kirobackend.service;

import lombok.AllArgsConstructor;
import ma.ensa.kirobackend.dtos.SprintBacklogDto;
import ma.ensa.kirobackend.entities.SprintBacklog;
import ma.ensa.kirobackend.exceptions.SprintBacklogNotFoundException;
import ma.ensa.kirobackend.mappers.developerMapper;
import ma.ensa.kirobackend.repository.SprintBacklogRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SprintBacklogServiceImpl implements SprintBacklogService{
    private SprintBacklogRepository sprintBacklogRepository;
    private developerMapper developerMapper;

    @Override
    public SprintBacklogDto viewSprintBacklog(Long id) {
        SprintBacklog sprintBacklog=sprintBacklogRepository.findById(id).orElse(null);
        if(sprintBacklog==null) throw new SprintBacklogNotFoundException("sprint Backlog not found ");
        SprintBacklogDto sprintBacklogDto= developerMapper.toSprintBacklogDto(sprintBacklog);

        return sprintBacklogDto;
    }
}
