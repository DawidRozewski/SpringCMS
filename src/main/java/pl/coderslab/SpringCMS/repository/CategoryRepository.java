package pl.coderslab.SpringCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.SpringCMS.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
