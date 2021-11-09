package pl.coderslab.SpringCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.SpringCMS.entity.Article;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findTop5ByOrderById();
}
