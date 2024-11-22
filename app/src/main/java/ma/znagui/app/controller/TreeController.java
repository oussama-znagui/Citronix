package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.service.TreeService;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trees")
public class TreeController {
    @Autowired
    TreeService service;

    @PostMapping
    public ResponseEntity<TreeResponseDTO> create(@Valid @RequestBody TreeCreateDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> getTree(@CheckExisting(entityC = Tree.class) @PathVariable("id") Long id){
        return ResponseEntity.ok(service.getTree(id));

    }
}
