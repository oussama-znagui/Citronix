package ma.znagui.app.dto.farm;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmResponseDTO {
    private Long id;
    private String name;
    private String location;
    private Double area;
    private LocalDate creationDate;

}