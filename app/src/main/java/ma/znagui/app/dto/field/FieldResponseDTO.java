package ma.znagui.app.dto.field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.farm.FarmEmbdedDTO;
import ma.znagui.app.dto.harvest.HarvestEmbdedDTO;
import ma.znagui.app.dto.tree.TreeEmbdedDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldResponseDTO {
    private Long id;
    private Double area;
    private FarmEmbdedDTO farm;
    List<TreeEmbdedDTO> trees;
    List<HarvestEmbdedDTO> harvests;
}
