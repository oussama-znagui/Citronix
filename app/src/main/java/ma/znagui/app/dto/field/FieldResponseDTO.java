package ma.znagui.app.dto.field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.farm.FarmEmbdedDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldResponseDTO {
    private Long id;
    private Double area;
    private FarmEmbdedDTO farm;
}
