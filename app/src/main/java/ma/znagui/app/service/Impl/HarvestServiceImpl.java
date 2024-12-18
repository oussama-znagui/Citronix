package ma.znagui.app.service.Impl;

import lombok.SneakyThrows;
import ma.znagui.app.dto.HarvestTree.HarvestTreeEmbdedDTO;
import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.enums.HarvestStatus;
import ma.znagui.app.exception.HarverstSeasonAlreadyExistsException;
import ma.znagui.app.exception.ResourceNotFoundExeption;
import ma.znagui.app.mapper.HarvestMapper;
import ma.znagui.app.mapper.HarvestTreeMapper;
import ma.znagui.app.repository.HarvestRepository;
import ma.znagui.app.service.FieldService;
import ma.znagui.app.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestServiceImpl implements HarvestService {
    @Autowired
    HarvestMapper mapper;
    @Autowired
    HarvestRepository repository;
    @Autowired
    FieldService fieldService;
    @Autowired
    HarvestTreeMapper harvestTreeMapper;

    @SneakyThrows
    public HarvestResponseDTO createHarvest(HarvestCreateDTO dto) {
        dto.setSeason(dto.getSeason().toUpperCase());
        Harvest harvest = mapper.createDTOtoHarvest(dto);
        harvest.setStatus(HarvestStatus.RIPE);

        Field field = fieldService.getFieldEntityByID(harvest.getField().getId());
        List<Harvest> harvestsOfyear =   field.getHarvests().stream().filter(harvest1 -> harvest1.getYear() == harvest.getYear()).toList();
        List<String> seasons = harvestsOfyear.stream().map(f -> f.getSeason().toString()).toList();


        boolean exesting = seasons.stream().anyMatch(harvest.getSeason().toString()::equals);

        System.out.println(exesting);
        if(field.getHarvests().size() == 4 || exesting){

            throw new HarverstSeasonAlreadyExistsException(harvest.getSeason().toString(), harvest.getId());

        }

        Harvest created = repository.save(harvest);
        created.setField(field);

        return mapper.harvestToResponseDTO(created);
        
    }

    public HarvestResponseDTO getOne(Long id) {
        Harvest harvest = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("harvest",id));
      Double a =   harvest.getHarvestTreesDetails().stream().mapToDouble(harvestTree -> harvestTree.getQuantity()).sum();
        HarvestResponseDTO harvestResponseDTO = mapper.harvestToResponseDTO(harvest);
        harvestResponseDTO.setTotale(a);


        List<HarvestTreeEmbdedDTO> harvestTreeEmbdedDTOS=  harvest.getHarvestTreesDetails().stream().map(harvestTree -> harvestTreeMapper.harvestTreeToEmbdedDTO(harvestTree)).toList();
    harvestResponseDTO.setHarvestTrees(harvestTreeEmbdedDTOS);
        return harvestResponseDTO;
    }

    public Harvest getHarvestEntityByID(Long id) {
        return  repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("harvest",id));
    }

    public HarvestResponseDTO deleteByID(Long id) {
        Harvest harvest = getHarvestEntityByID(id);
        repository.deleteById(id);
        return mapper.harvestToResponseDTO(harvest);
    }
}
