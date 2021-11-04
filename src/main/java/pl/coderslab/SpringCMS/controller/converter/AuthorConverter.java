package pl.coderslab.SpringCMS.controller.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.SpringCMS.dao.AuthorDao;
import pl.coderslab.SpringCMS.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    private final AuthorDao authorDao;

    public AuthorConverter(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String source) {
        return authorDao.findById(Integer.parseInt(source));
    }
}