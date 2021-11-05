package pl.coderslab.SpringCMS.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.SpringCMS.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Article article) {
        entityManager.persist(article);
    }

    public void merge(Article article) {
        entityManager.merge(article);
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public void remove(long id) {
        Article article = findById(id);
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public List<Article> findAll() {
        Query query = entityManager.createQuery("SELECT a from Article a");
        return query.getResultList();
    }

    public List<Article> getLastFiveArticles() {
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        query.setMaxResults(5);
        return query.getResultList();
    }
}
