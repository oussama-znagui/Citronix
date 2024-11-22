package ma.znagui.app.service;

import ma.znagui.app.dto.field.FieldCreateDTO;
import ma.znagui.app.dto.field.FieldResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;

public interface FieldService {

    public FieldResponseDTO createField(FieldCreateDTO dto);
    public FieldResponseDTO getfield(Long field);
    public Field getFieldEntityByID(Long id);
    public boolean isFieldacceptNowTree(Field field);


}
