package ma.znagui.app.service;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;

import java.time.LocalDate;
import java.util.List;

public interface FarmService {
     FarmResponseDTO create(FarmCreateDTO dto);
     FarmResponseDTO getOneFarm(Long id);
     Farm getFarmEntityByID(Long id);
     FarmResponseDTO updateFarm(FarmCreateDTO dto,Long farmID);

     Double getFarmfreeArea(Farm farm);


     List<FarmResponseDTO> findFarms(String name, String location, LocalDate creationDate);
    FarmResponseDTO deleteByID(Long id);

}
