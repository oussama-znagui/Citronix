package ma.znagui.app.service;

import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Harvest;

public interface HarvestService {
    public HarvestResponseDTO createHarvest(HarvestCreateDTO dto);
    public HarvestResponseDTO getOne(Long id);
    public Harvest getHarvestEntityByID(Long id);
}
