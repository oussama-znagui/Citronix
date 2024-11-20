package ma.znagui.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.znagui.app.enums.HarvestStatus;
import ma.znagui.app.enums.Season;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Season season;
    private HarvestStatus status;
    private LocalDate date;

}
