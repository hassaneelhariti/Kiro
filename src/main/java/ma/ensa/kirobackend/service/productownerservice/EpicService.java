package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.EpicDto;

import java.util.List;

public interface EpicService {

    List<EpicDto> getAllEpics();

    EpicDto getEpic(Long id);

    EpicDto createEpic(EpicDto epicDto);

    void deleteEpic(Long id);

}
