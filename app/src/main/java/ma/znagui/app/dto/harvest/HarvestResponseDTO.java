package ma.znagui.app.dto.harvest;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.field.FieldEmbdedDTO;
import ma.znagui.app.entity.Field;
import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.enums.HarvestStatus;
import ma.znagui.app.enums.Season;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestResponseDTO {
    private Long id;
    private String season;
    private String status;
    private int year;
    private Double totale;
    private FieldEmbdedDTO field;
//    private List<>
}
