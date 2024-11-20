package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farm")
public class FarmController {

    @GetMapping
    public ResponseEntity<String> getFarms(){
        return ResponseEntity.ok("bonjour");
    }

    @PostMapping
    public ResponseEntity<FarmResponseDTO> create(@Valid @RequestBody FarmCreateDTO dto){
        return null;
    }


}
