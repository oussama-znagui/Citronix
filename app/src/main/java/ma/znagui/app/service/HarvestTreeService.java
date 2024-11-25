package ma.znagui.app.service;

import ma.znagui.app.dto.HarvestTree.HarvestTreeCreateDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeResponseDTO;
import ma.znagui.app.dto.harvest.HarvestResponseDTO;

public interface HarvestTreeService {
    public HarvestTreeResponseDTO createHarvestTree(HarvestTreeCreateDTO dto);
    public HarvestTreeResponseDTO getHarvestTree(Long harvestID,Long treeID);
}
