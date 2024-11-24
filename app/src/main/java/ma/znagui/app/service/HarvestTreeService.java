package ma.znagui.app.service;

import ma.znagui.app.dto.HarvestTree.HarvestTreeCreateDTO;
import ma.znagui.app.dto.HarvestTree.HarvestTreeResponseDTO;

public interface HarvestTreeService {
    public HarvestTreeResponseDTO createHarvestTree(HarvestTreeCreateDTO dto);
}
