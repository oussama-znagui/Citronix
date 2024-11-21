package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trees")
public class TreeController {
    @Autowired
    TreeService service;

    @PostMapping
    public ResponseEntity<TreeResponseDTO> create(@Valid @RequestBody TreeCreateDTO dto){
//        return ResponseEntity.ok(service.create(dto));
        return null;
    }
}
