package ma.znagui.app.dto.HarvestTree;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.entity.Tree;
import ma.znagui.app.validation.api.CheckExisting;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestTreeCreateDTO {
    @NotNull(message = "ID de la recolte SVP !!")
    @CheckExisting(entityC = Harvest.class)
    private Long harvestID;

    @NotNull(message = "ID de l'arbre SVP !!")
    @CheckExisting(entityC = Tree.class)
    private Long treeID;

    @NotNull(message = "La quantite SVP !!")
    private Double quantity;
}
