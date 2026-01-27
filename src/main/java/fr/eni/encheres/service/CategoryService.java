package fr.eni.encheres.service;

import fr.eni.encheres.entity.Category;
import java.util.List;

public interface CategoryService {

    void createCategory(Category category);
    Category getById(long id);
    List<Category> getAll();
    void deleteCategory(long id);
    void updateCategory(Category category);

}
