package pl.coderslab.SpringCMS.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.SpringCMS.repository.AuthorRepository;
import pl.coderslab.SpringCMS.entity.Author;

@Component
public class AuthorConverter implements Converter<String, Author> {
    private final AuthorRepository authorRepository;

    public AuthorConverter(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author convert(String source) {
        return authorRepository.getById(Long.parseLong(source));
    }
}
