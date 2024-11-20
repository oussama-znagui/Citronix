package ma.znagui.app.service;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;

public interface FarmService {
    public FarmResponseDTO create(FarmCreateDTO dto);
}
