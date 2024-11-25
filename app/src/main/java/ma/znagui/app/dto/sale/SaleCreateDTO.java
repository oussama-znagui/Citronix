package ma.znagui.app.dto.sale;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.validation.api.CheckExisting;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCreateDTO {
    @NotBlank(message = "le nom du client svp SVP!")
    private String clientName;
    @NotNull(message = "la quantite svp!")
    private int qte;
    @NotNull(message = "le prix Unitaire SVP!")
    private Double unitPrice;

    @CheckExisting(entityC = Harvest.class)
    @NotNull(message = "ID de la ricolt SVP!")
    private Long harvestID;
}
