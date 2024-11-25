package ma.znagui.app.service;

import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.dto.sale.SaleCreateDTO;
import ma.znagui.app.dto.sale.SaleResponseDTO;
import ma.znagui.app.entity.Sale;

public interface SaleService {
    public SaleResponseDTO createSale(SaleCreateDTO dto);
    public SaleResponseDTO getSale(Long id);

    SaleResponseDTO deleteByID(Long id);
}
