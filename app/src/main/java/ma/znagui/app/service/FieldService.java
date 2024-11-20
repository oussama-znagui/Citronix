package ma.znagui.app.service;

import ma.znagui.app.dto.field.FieldCreateDTO;
import ma.znagui.app.dto.field.FieldResponseDTO;

public interface FieldService {

    public FieldResponseDTO createField(FieldCreateDTO dto);

}
