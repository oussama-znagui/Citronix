package ma.znagui.app.controller;

import jakarta.validation.Valid;
import ma.znagui.app.dto.HarvestTree.HarvestTreeCreateDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeResponseDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.service.HarvestTreeService;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/harvest-tree")
public class HarvestTreeController {
    @Autowired
    HarvestTreeService service;

    @PostMapping
    public ResponseEntity<HarvestTreeResponseDTO> create(@Valid @RequestBody HarvestTreeCreateDTO dto){
        return ResponseEntity.ok(service.createHarvestTree(dto));

    }

    @GetMapping(value = "/{harvestID}/{treeID}")
    public ResponseEntity<HarvestTreeResponseDTO> getOne(@CheckExisting(entityC = Harvest.class ) @PathVariable("harvestID") Long harvestID, @CheckExisting(entityC = Tree.class ) @PathVariable("treeID") Long treeID){
        return ResponseEntity.ok(service.getHarvestTree(harvestID,treeID));
    }

}
