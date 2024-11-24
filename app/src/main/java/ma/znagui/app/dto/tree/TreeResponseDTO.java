package ma.znagui.app.dto.tree;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.field.FieldEmbdedDTO;
import ma.znagui.app.entity.Field;
import ma.znagui.app.entity.HarvestTree;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeResponseDTO {
    private Long id;
    private LocalDate plantingDate;
    private int age;
    private FieldEmbdedDTO field;



//    private List<HarvestTree> harvestTreesDetails;

}
