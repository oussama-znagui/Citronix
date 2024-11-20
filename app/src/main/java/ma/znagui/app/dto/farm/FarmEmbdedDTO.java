package ma.znagui.app.dto.farm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmEmbdedDTO {
    private Long id;
    private String name;
    private String location;
    private Double area;
    private LocalDate creationDate;
}
