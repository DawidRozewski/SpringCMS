package pl.coderslab.SpringCMS.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Category;

@Component
public class CategoryConverter implements Converter<String, Category> {
    private final CategoryDao categoryDao;

    public CategoryConverter(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String source) {
        return categoryDao.findById(Integer.parseInt(source));
    }
}
