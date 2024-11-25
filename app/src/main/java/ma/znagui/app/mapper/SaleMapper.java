package ma.znagui.app.mapper;

import ma.znagui.app.dto.sale.SaleCreateDTO;
import ma.znagui.app.dto.sale.SaleResponseDTO;
import ma.znagui.app.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {HarvestMapper.class})
public interface SaleMapper {
    @Mapping(target = "harvest.id" ,source = "harvestID")
    public Sale createDTOtoSale(SaleCreateDTO dto);

    public SaleResponseDTO saleToResponseEntity(Sale sale);

}
