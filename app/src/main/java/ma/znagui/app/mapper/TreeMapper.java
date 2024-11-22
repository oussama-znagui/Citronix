package ma.znagui.app.mapper;

import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeEmbdedDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.entity.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" )
public interface TreeMapper {

    @Mapping(target = "field.id" ,source = "fieldID")
    public Tree createDTOtoTree(TreeCreateDTO dto);

    public TreeResponseDTO treeToResponseDTO(Tree tree);

    public TreeEmbdedDTO treeToEmbddedDTO(Tree tree);


}
