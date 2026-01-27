package fr.eni.encheres.service;

import fr.eni.encheres.entity.Category;
import fr.eni.encheres.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(Category category) {
        this.categoryRepository.createCategory(category);
    }

    @Override
    public Category getById(long id) {
        return this.categoryRepository.getById(id);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.getAll();
    }

    @Override
    public void deleteCategory(long id) {
        this.categoryRepository.deleteCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryRepository.updateCategory(category);
    }
}
