package ma.znagui.app.dto.harvest;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.entity.Field;
import ma.znagui.app.enums.Season;
import ma.znagui.app.validation.api.CheckExisting;

import java.time.LocalDate;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestCreateDTO {

//    @NotBlank(message = "la saison SVP!!!")
    @AssertTrue(message = "ya que 4 saison dans l'annee")
    public boolean isSeasonValid() {
    return Arrays.stream(Season.values())
            .anyMatch(s -> s.name().equalsIgnoreCase(season));
    }
    private String season;
    @Min(2000)
    @Max(20230)
    private int year;

    @NotNull(message = "le champ SVP !!")
    @CheckExisting(entityC = Field.class)
    private Long fieldID;
}
