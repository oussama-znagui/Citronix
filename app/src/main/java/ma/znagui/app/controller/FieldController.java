package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.dto.field.FieldCreateDTO;
import ma.znagui.app.dto.field.FieldResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;
import ma.znagui.app.service.FieldService;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/field")
public class FieldController {
    @Autowired
    FieldService service;

    @PostMapping
    public ResponseEntity<FieldResponseDTO> createField(@Valid @RequestBody FieldCreateDTO dto){
        return ResponseEntity.ok(service.createField(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> getField(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getfield(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> delete(@CheckExisting(entityC = Farm.class) @PathVariable("id") Long id){
        return ResponseEntity.ok(service.deleteByID(id));

    }




}
