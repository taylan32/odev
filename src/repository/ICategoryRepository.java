package repository;

import entity.Category;

import java.util.List;

public interface ICategoryRepository {

    // An interface for category repository
    List<Category> findAll();
    Category findById(Long id);

}
