package ma.znagui.app.dto.harvest;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.entity.Field;
import ma.znagui.app.enums.Season;
import ma.znagui.app.validation.api.CheckExisting;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestCreateDTO {
    @NotBlank(message = "la saison SVP!!!")
    private String season;
    @Min(2000)
    @Max(20230)
    private int date;

    @NotNull(message = "le champ SVP !!")
    @CheckExisting(entityC = Field.class)
    private Long fieldID;
}
