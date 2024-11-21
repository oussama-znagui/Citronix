package ma.znagui.app.mapper;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = FieldMapper.class)
public interface FarmMapper {

    public Farm createDTOtofarm(FarmCreateDTO dto);
    public FarmResponseDTO farmToResponseDTO(Farm farm);

}
