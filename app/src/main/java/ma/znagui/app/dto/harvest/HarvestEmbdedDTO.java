package ma.znagui.app.dto.harvest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.enums.HarvestStatus;
import ma.znagui.app.enums.Season;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestEmbdedDTO {
    private Long id;
    private Season season;
    private HarvestStatus status;
    private int year;
}
