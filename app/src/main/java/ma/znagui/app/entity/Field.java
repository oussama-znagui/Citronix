package ma.znagui.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double area;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @OneToMany(mappedBy = "field")
    private List<Tree> trees;
}
