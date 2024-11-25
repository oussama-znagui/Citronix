package ma.znagui.app.mapper;

import ma.znagui.app.dto.HarvestTree.HarvestTreeCreateDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeEmbdedDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeResponseDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.entity.HarvestTree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface HarvestTreeMapper {

    @Mappings({
            @Mapping(target = "id.harvestId", source = "harvestID"),
            @Mapping(target = "id.treeId", source = "treeID"),
            //probleme de persistance

            @Mapping(target = "harvest.id", source = "harvestID"),
            @Mapping(target = "tree.id", source = "treeID")
    })
   public HarvestTree createDTOtoHarvestTree(HarvestTreeCreateDTO dto);

    public HarvestTreeResponseDTO harvestTreeToResponseDTO(HarvestTree harvestTree);
    public HarvestTreeEmbdedDTO harvestTreeToEmbdedDTO(HarvestTree harvestTree);
}
