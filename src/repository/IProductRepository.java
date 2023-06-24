package repository;

import entity.Product;

import java.util.List;

public interface IProductRepository {

    // An interface for product repository
    List<Product> findAll();
    Product findById(Long id);
    void add(Product product);
}
