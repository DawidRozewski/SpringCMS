package pl.coderslab.SpringCMS.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.SpringCMS.entity.Article;
import pl.coderslab.SpringCMS.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Category category) {
        entityManager.persist(category);
    }

    public void merge(Category category) {
        entityManager.merge(category);
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void remove(long id) {
        Category category = findById(id);
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public List<Category> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

}
