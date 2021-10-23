package pl.coderslab.SpringCMS.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.SpringCMS.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Author author) {
        entityManager.persist(author);
    }

    public void merge(Author author) {
        entityManager.merge(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void remove(long id) {
        Author author = findById(id);
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }
}
