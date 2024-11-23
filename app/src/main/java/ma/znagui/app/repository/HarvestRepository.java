package ma.znagui.app.repository;

import ma.znagui.app.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest,Long> {

}
