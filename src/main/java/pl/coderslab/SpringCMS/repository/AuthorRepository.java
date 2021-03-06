package pl.coderslab.SpringCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.SpringCMS.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
