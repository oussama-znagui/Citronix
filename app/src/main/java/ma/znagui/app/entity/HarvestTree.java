package ma.znagui.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HarvestTree {
    @EmbeddedId
    private HarvestTreeKey id;


    @ManyToOne
    @MapsId("harvestId")
    @JoinColumn(name = "harvest_id",nullable = false)
    private Harvest harvest;

    @ManyToOne
    @MapsId("treeId")
    @JoinColumn(name = "tree_id",nullable = false)
    private Tree tree;

    private int Quantity;


}