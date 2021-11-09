package pl.coderslab.SpringCMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.SpringCMS.entity.Article;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findTop5ByOrderById();
}
