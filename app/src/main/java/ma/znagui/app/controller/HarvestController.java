package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.harvest.HarvestCreateDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/harvests")
public class HarvestController {

    @PostMapping
    public ResponseEntity<HarvestResponseDTO> create(@Valid @RequestBody HarvestCreateDTO dto){
//        return ResponseEntity.ok();
        return null;
    }
}
