package ma.znagui.app.service;

import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;
import ma.znagui.app.entity.Tree;

import java.time.LocalDate;

public interface TreeService {
    public TreeResponseDTO create(TreeCreateDTO dto);
    public TreeResponseDTO getTree(Long id);
    public Tree getTreeEntityByID(Long id);
    public int calculateAgeOfTree(LocalDate date);

}
