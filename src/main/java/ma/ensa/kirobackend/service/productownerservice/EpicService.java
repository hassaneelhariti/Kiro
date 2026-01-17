package ma.ensa.kirobackend.service.productownerservice;

import ma.ensa.kirobackend.dtos.EpicDto;

public interface EpicService {

    EpicDto getEpic(Long id);

    EpicDto createEpic(EpicDto epicDto);

    void deleteEpic(Long id);

}
