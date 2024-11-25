package ma.znagui.app.service;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;

import java.time.LocalDate;
import java.util.List;

public interface FarmService {
    public FarmResponseDTO create(FarmCreateDTO dto);
    public FarmResponseDTO getOneFarm(Long id);
    public Farm getFarmEntityByID(Long id);
    public FarmResponseDTO updateFarm(FarmCreateDTO dto,Long farmID);

    public Double getFarmfreeArea(Farm farm);


    public List<FarmResponseDTO> findFarms(String name, String location, LocalDate creationDate);
}
