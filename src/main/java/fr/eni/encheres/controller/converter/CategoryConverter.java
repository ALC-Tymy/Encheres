package fr.eni.encheres.controller.converter;

import fr.eni.encheres.entity.Category;
import fr.eni.encheres.service.CategoryService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<String, Category> {

    CategoryService categoryService;

    public CategoryConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category convert(String isString) {
        Long id = Long.parseLong(isString);
        return categoryService.getById(id);
    }
}

