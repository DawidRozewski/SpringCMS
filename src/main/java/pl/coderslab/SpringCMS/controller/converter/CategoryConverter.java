package pl.coderslab.SpringCMS.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.SpringCMS.dao.CategoryRepository;
import pl.coderslab.SpringCMS.entity.Category;

@Component
public class CategoryConverter implements Converter<String, Category> {
    private final CategoryRepository categoryDao;

    public CategoryConverter(CategoryRepository categoryRepository) {
        this.categoryDao = categoryRepository;
    }

    @Override
    public Category convert(String source) {
        return categoryDao.getById(Long.parseLong(source));
    }
}
