package ma.znagui.app.specification;

import ma.znagui.app.entity.Farm;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class FarmSpecifications {
    public static Specification<Farm> hasLocation(String location) {
        return (root, query, criteriaBuilder) -> location == null ? null : criteriaBuilder.like(root.get("location"), "%" + location + "%");
    }


    public static Specification<Farm> hasName(String name) {
        return (root, query, criteriaBuilder) -> name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }


    public static Specification<Farm> wasCreatedAfter(LocalDate date) {
        return (root, query, criteriaBuilder) -> date == null ? null : criteriaBuilder.greaterThan(root.get("creationDate"), date);
    }
}
