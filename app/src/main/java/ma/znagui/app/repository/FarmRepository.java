package ma.znagui.app.repository;

import ma.znagui.app.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm,Long> {
}
