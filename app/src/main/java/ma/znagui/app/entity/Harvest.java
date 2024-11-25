package ma.znagui.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.znagui.app.enums.HarvestStatus;
import ma.znagui.app.enums.Season;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Season season;
    private HarvestStatus status;
    @NotNull
    private int year;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "field_id")
    private Field field;

    @OneToMany(mappedBy = "harvest"  ,cascade = CascadeType.REMOVE)
    private List<HarvestTree> harvestTreesDetails;

    @OneToMany(mappedBy = "harvest")
    List<Sale> sales;

}
