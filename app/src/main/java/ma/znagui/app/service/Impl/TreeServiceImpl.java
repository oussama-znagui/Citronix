package ma.znagui.app.service.Impl;

import lombok.SneakyThrows;
import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.entity.Field;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.exception.DateInvalideForPnating;
import ma.znagui.app.exception.ResourceNotFoundExeption;
import ma.znagui.app.exception.TreeCannotBePlantedException;
import ma.znagui.app.mapper.TreeMapper;
import ma.znagui.app.repository.TreeRepository;
import ma.znagui.app.service.FieldService;
import ma.znagui.app.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    TreeMapper mapper;
    @Autowired
    FieldService fieldService;
    @Autowired
    TreeRepository repository;


    @SneakyThrows
    public TreeResponseDTO create(TreeCreateDTO dto) {
        Tree tree = mapper.createDTOtoTree(dto);
        Field field = fieldService.getFieldEntityByID(tree.getField().getId());
        if (!dateIsValid(tree.getPlantingDate())){
            throw new  DateInvalideForPnating();
        }

        if (fieldService.isFieldacceptNowTree(field)){
            repository.save(tree);
            tree.setField(field);
            return mapper.treeToResponseDTO(tree);
        }else {
            throw new TreeCannotBePlantedException(field.getId());
        }

    }

    public TreeResponseDTO getTree(Long id) {
      Tree tree = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Arbre",id));
      return mapper.treeToResponseDTO(tree);
    }

    private boolean dateIsValid(LocalDate date){
        return date.getMonth() == Month.MARCH || date.getMonth() == Month.APRIL || date.getMonth() == Month.MAY;
    }
}
