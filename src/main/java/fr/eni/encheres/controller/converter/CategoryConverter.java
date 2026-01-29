package fr.eni.encheres.controller.converter;

import fr.eni.encheres.entity.Category;
import fr.eni.encheres.service.CategoryService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<String, Category> {

    private final CategoryService categoryService;

    public CategoryConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category convert(String value) {
        if (value == null || value.isBlank()) {
            return null; // l'option vide du <select>
        }

        Long id = Long.parseLong(value);
        return categoryService.getById(id);
    }
}