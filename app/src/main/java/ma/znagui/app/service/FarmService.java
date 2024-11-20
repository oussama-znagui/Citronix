package ma.znagui.app.service;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;

public interface FarmService {
    public FarmResponseDTO create(FarmCreateDTO dto);
    public FarmResponseDTO getOneFarm(Long id);
    public Farm getFieldEntityByID(Long id);
    public Double getFarmfreeArea(Farm farm);
}
