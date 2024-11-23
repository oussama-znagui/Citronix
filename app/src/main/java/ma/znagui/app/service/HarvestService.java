package ma.znagui.app.service;

import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;

public interface HarvestService {
    public HarvestResponseDTO createHarvest(HarvestCreateDTO dto);
}
