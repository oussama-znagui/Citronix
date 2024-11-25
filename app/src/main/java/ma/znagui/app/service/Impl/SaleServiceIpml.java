package ma.znagui.app.service.Impl;

import ma.znagui.app.dto.sale.SaleCreateDTO;
import ma.znagui.app.dto.sale.SaleResponseDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.entity.Sale;
import ma.znagui.app.exception.InsuffisantSaleQuantityException;
import ma.znagui.app.exception.ResourceNotFoundExeption;
import ma.znagui.app.mapper.SaleMapper;
import ma.znagui.app.repository.SaleRepository;
import ma.znagui.app.service.HarvestService;
import ma.znagui.app.service.SaleService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceIpml implements SaleService {
    @Autowired
    SaleMapper mapper;
    @Autowired
    SaleRepository repository;
    @Autowired
    HarvestService harvestService;



    public SaleResponseDTO createSale(SaleCreateDTO dto) {
        Sale sale = mapper.createDTOtoSale(dto);
        Harvest harvest = harvestService.getHarvestEntityByID(sale.getHarvest().getId());

        Double qteTotal =   harvest.getHarvestTreesDetails().stream().mapToDouble(HarvestTree::getQuantity).sum();
        int saled = harvest.getSales().stream().mapToInt(Sale::getQte).sum();

        System.out.println(qteTotal);
        System.out.println(saled);
        if (qteTotal  - saled < sale.getQte()){

            throw  new InsuffisantSaleQuantityException(qteTotal-saled,harvest.getId());

        }else {

            Sale sale1 = repository.save(sale);
            sale1.setHarvest(harvest);

            SaleResponseDTO responseDTO = mapper.saleToResponseEntity(sale);
            responseDTO.setTotale(calculatePrice(sale.getUnitPrice(), sale.getQte()));
            return responseDTO;

        }






    }

    public SaleResponseDTO getSale(Long id) {
        Sale sale = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Vente",id));
        SaleResponseDTO responseDTO = mapper.saleToResponseEntity(sale);
        responseDTO.setTotale(calculatePrice(sale.getUnitPrice(), sale.getQte()));
        return responseDTO;
    }

    @Override
    public SaleResponseDTO deleteByID(Long id) {
        return null;
    }

    private Double calculatePrice(Double prixU,int qte){
        return prixU*qte;
    }
}
