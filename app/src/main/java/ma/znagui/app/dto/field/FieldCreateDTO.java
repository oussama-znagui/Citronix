package ma.znagui.app.dto.field;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;
import ma.znagui.app.validation.api.CheckExisting;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldCreateDTO {
    @NotNull(message = "le superficie du champ SVP!")
    private Double area;
    @NotNull(message = "le superficie du champ SVP!")
    @CheckExisting(entityC = Farm.class)
    private Long farmID;
}
