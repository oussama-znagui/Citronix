package ma.znagui.app.dto.HarvestTree;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.tree.TreeEmbdedDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestTreeEmbdedDTO {
    private TreeEmbdedDTO tree;
    private Double quantity;
}
