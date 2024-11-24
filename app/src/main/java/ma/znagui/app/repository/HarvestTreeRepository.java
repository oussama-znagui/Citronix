package ma.znagui.app.repository;

import ma.znagui.app.entity.HarvestTree;
import ma.znagui.app.entity.HarvestTreeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestTreeRepository extends JpaRepository<HarvestTree, HarvestTreeKey> {
}
