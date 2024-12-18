package ma.znagui.app.dto.field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.tree.TreeEmbdedDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldEmbdedDTO {
    private Long id;
    private Double area;
   private List<TreeEmbdedDTO> trees;

}
