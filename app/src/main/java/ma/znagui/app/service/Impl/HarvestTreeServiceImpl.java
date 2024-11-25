package ma.znagui.app.service.Impl;

import lombok.SneakyThrows;
import ma.znagui.app.dto.HarvestTree.HarvestTreeCreateDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeResponseDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.entity.HarvestTreeKey;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.exception.NonMatchingField;
import ma.znagui.app.exception.ResourceNotFoundExeption;
import ma.znagui.app.exception.UnproductiveTreeException;
import ma.znagui.app.mapper.HarvestTreeMapper;
import ma.znagui.app.repository.HarvestTreeRepository;
import ma.znagui.app.service.HarvestService;
import ma.znagui.app.service.HarvestTreeService;
import ma.znagui.app.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HarvestTreeServiceImpl implements HarvestTreeService {
    @Autowired
    HarvestTreeMapper mapper;
    @Autowired
    TreeService treeService;
    @Autowired
    HarvestService harvestService;
    @Autowired
    HarvestTreeRepository repository;



    @SneakyThrows
    public HarvestTreeResponseDTO createHarvestTree(HarvestTreeCreateDTO dto){
        HarvestTree harvestTree = mapper.createDTOtoHarvestTree(dto);
        Tree tree = treeService.getTreeEntityByID(harvestTree.getId().getTreeId());
        Harvest harvest = harvestService.getHarvestEntityByID(harvestTree.getId().getHarvestId());

        if (tree.getField().getId() != harvest.getField().getId()){
            throw new NonMatchingField(harvestTree.getId().getHarvestId(), tree.getField().getId());
        }
        if (treeService.calculateAgeOfTree(tree.getPlantingDate()) >= 20){
            throw new UnproductiveTreeException(tree.getId());
        }

        return mapper.harvestTreeToResponseDTO(repository.save(harvestTree));
    }


    public HarvestTreeResponseDTO getHarvestTree(Long harvestID, Long treeID) {
        HarvestTreeKey harvestTreeKey = new HarvestTreeKey(harvestID,treeID);
        HarvestTree harvestTree = repository.findById(harvestTreeKey).orElseThrow(() -> new ResourceNotFoundExeption("harvestTree",harvestID,treeID));
        return mapper.harvestTreeToResponseDTO(harvestTree);
    }
}
