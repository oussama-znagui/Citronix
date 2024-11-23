package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.service.HarvestService;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harvests")
public class HarvestController {
    @Autowired
    HarvestService service;

    @PostMapping
    public ResponseEntity<HarvestResponseDTO> create(@Valid @RequestBody HarvestCreateDTO dto){
        return ResponseEntity.ok(service.createHarvest(dto));

    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> getHarvest(@CheckExisting(entityC = Harvest.class) @PathVariable("id") Long id){
        return ResponseEntity.ok(service.getOne(id));
    }



}
