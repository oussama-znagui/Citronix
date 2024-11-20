package ma.znagui.app.mapper;

import ma.znagui.app.dto.field.FieldCreateDTO;
import ma.znagui.app.dto.field.FieldResponseDTO;
import ma.znagui.app.entity.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    @Mapping(target = "farm.id" ,source = "farmID")
    public Field createDTOtoField(FieldCreateDTO dto);

    public FieldResponseDTO fieldToResponseDTO(Field field);


}
