package ma.znagui.app.repository;

import ma.znagui.app.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field,Long> {
}
