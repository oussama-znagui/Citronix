package ma.znagui.app.repository;

import ma.znagui.app.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FarmRepository extends JpaRepository<Farm,Long> , JpaSpecificationExecutor<Farm> {
}
