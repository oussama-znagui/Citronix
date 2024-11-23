package ma.znagui.app.service.Impl;

import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.mapper.HarvestMapper;
import ma.znagui.app.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;

public class HarvestServiceImpl implements HarvestService {
    @Autowired
    HarvestMapper mapper;


    public HarvestResponseDTO createHarvest(HarvestCreateDTO dto) {
        Harvest harvest = mapper.createDTOtoHarvest(dto);


        
    }
}
