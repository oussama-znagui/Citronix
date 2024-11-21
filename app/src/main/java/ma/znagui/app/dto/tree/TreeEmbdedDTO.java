package ma.znagui.app.dto.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeEmbdedDTO {
    private Long id;
    private LocalDate plantingDate;
}
