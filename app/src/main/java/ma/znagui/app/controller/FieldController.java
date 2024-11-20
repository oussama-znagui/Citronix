package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.field.FieldCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/field")
public class FieldController {

    @PostMapping
    public ResponseEntity<String> createField(@Valid @RequestBody FieldCreateDTO dto){
        return ResponseEntity.ok("bonjour");
    }

}
