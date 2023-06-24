package repository;

import entity.Category;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class CategoryRepository implements ICategoryRepository {

    // Initial data for some categories
    Category category1 = new Category(Long.valueOf(1), "technology");
    Category category2 = new Category(Long.valueOf(2), "home");
    Category category3 = new Category(Long.valueOf(3), "Clothes");
    private List<Category> categories = Arrays.asList(category1, category2, category3);

    // a method to list all existing categories
    @Override
    public List<Category> findAll() {
        return this.categories;
    }

    // A method to find a product by its id.
    @Override
    public Category findById(Long id) {
        return this.categories.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }



}
