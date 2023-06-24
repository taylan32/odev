package service;

import entity.Category;
import repository.ICategoryRepository;

public class CategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // a method to find category with its id
    protected Category findById(Long id) {
        return this.categoryRepository.findById(id);
    }


}
