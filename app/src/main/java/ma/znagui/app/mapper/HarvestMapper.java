package ma.znagui.app.mapper;

import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestEmbdedDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Harvest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FieldMapper.class)
public interface HarvestMapper {

    @Mapping(target = "field.id",source = "fieldID")
    public Harvest createDTOtoHarvest(HarvestCreateDTO dto);

    public HarvestResponseDTO harvestToResponseDTO(Harvest harvest);
    public HarvestEmbdedDTO harvestToEmbdedDTO(Harvest harvest);
}
