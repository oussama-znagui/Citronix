package ma.znagui.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String clientName;
    @NotNull
    private int qte;
    @NotNull
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "harvest_id" ,nullable = false)
    private Harvest harvest;
}
