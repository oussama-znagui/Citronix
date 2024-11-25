package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.sale.SaleCreateDTO;
import ma.znagui.app.dto.sale.SaleResponseDTO;
import ma.znagui.app.entity.Sale;
import ma.znagui.app.service.SaleService;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(@Valid @RequestBody SaleCreateDTO dto){
        return ResponseEntity.ok(saleService.createSale(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> getOne(@CheckExisting(entityC = Sale.class) @PathVariable("id") Long id){
        return ResponseEntity.ok(saleService.getSale(id));
    }


}
