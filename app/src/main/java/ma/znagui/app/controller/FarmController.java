package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.service.FarmService;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {
    @Autowired
    FarmService service;

    @GetMapping
    public ResponseEntity<String> getFarms(){
        return ResponseEntity.ok("bonjour");
    }

    @PostMapping
    public ResponseEntity<FarmResponseDTO> create(@Valid @RequestBody FarmCreateDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<FarmResponseDTO> getFarm(@CheckExisting(entityC = Farm.class) @PathVariable("id") Long id){
        return ResponseEntity.ok(service.getOneFarm(id));
    }

    @GetMapping("/searsh")
    public ResponseEntity<List<FarmResponseDTO>> serashFarm(@RequestParam(required = false) String name,
                                                            @RequestParam(required = false) String location,
                                                            @RequestParam(required = false) LocalDate creationDate){
        return ResponseEntity.ok(service.findFarms(name,location,creationDate));

    }



}
