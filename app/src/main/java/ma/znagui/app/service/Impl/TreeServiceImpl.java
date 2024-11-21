package ma.znagui.app.service.Impl;

import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.entity.Field;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.mapper.TreeMapper;
import ma.znagui.app.service.FieldService;
import ma.znagui.app.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    TreeMapper mapper;
    @Autowired
    FieldService fieldService;


    public TreeResponseDTO create(TreeCreateDTO dto) {
        Tree tree = mapper.createDTOtoTree(dto);
        Field field = fieldService.getFieldEntityByID(tree.getField().getId());
        


        return null;
    }
}
