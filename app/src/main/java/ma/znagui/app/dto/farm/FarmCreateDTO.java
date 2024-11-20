package ma.znagui.app.dto.farm;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmCreateDTO {
    @NotBlank(message = "le nom de la ferme svp")
    private String name;
    @NotBlank(message = "la localisation de la ferme svp")
    private String location;
    @NotNull(message = "la superficie de la ferme svp!")
    @Min(value = 2000)
    private Double area;
}
