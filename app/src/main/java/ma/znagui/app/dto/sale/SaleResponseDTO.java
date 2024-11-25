package ma.znagui.app.dto.sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.dto.HarvestTree.HarvestTreeEmbdedDTO;
import ma.znagui.app.dto.harvest.HarvestEmbdedDTO;
import ma.znagui.app.entity.Harvest;
import ma.znagui.app.validation.api.CheckExisting;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SaleResponseDTO {
   private int id;
    private String clientName;
    private int qte;
    private Double unitPrice;
    private HarvestEmbdedDTO harvest;
    private Double totale;
}
