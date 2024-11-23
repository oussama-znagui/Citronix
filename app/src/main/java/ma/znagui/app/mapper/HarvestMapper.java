package ma.znagui.app.mapper;

import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Harvest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestMapper {

    @Mapping(target = "field.id",source = "fieldID")
    public Harvest createDTOtoHarvest(HarvestCreateDTO dto);

    public HarvestResponseDTO harvestToResponseDTO(Harvest harvest);
}
