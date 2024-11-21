package ma.znagui.app.repository;

import ma.znagui.app.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree,Long> {
}
