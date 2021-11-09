package pl.coderslab.SpringCMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.SpringCMS.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
