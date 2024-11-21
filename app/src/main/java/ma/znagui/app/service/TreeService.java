package ma.znagui.app.service;

import ma.znagui.app.dto.tree.TreeCreateDTO;
import ma.znagui.app.dto.tree.TreeResponseDTO;

public interface TreeService {
    public TreeResponseDTO create(TreeCreateDTO dto);

}
