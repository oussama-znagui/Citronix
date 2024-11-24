package ma.znagui.app.service.Impl;

import lombok.SneakyThrows;
import ma.znagui.app.dto.HarvestTree.HarvestTreeCreateDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeResponseDTO;
import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.exception.UnproductiveTreeException;
import ma.znagui.app.mapper.HarvestTreeMapper;
import ma.znagui.app.repository.HarvestTreeRepository;
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
    HarvestTreeRepository repository;



    @SneakyThrows
    public HarvestTreeResponseDTO createHarvestTree(HarvestTreeCreateDTO dto){
        HarvestTree harvestTree = mapper.createDTOtoHarvestTree(dto);
        Tree tree = treeService.getTreeEntityByID(harvestTree.getId().getTreeId());
// verification de champs
        if (treeService.calculateAgeOfTree(tree.getPlantingDate()) >= 20){
            throw new UnproductiveTreeException(tree.getId());
        }

        return mapper.harvestTreeToResponseDTO(repository.save(harvestTree));
    }
}
