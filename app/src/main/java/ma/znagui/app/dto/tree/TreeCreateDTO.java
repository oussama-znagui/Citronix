package ma.znagui.app.dto.tree;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ma.znagui.app.entity.Field;
import ma.znagui.app.validation.api.CheckExisting;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeCreateDTO {
    @NotNull(message = "la date svp ! ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate plantingDate;
    @NotNull(message = "ID du champ est obligatoire")
    @CheckExisting(entityC = Field.class)
    private Long fieldID;

}
