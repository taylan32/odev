package repository;

import entity.Category;
import entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository{

    // A class for fake data operations.

    private List<Product> products = new ArrayList<>();


    // a method to list all existing products
    @Override
    public List<Product> findAll() {
        products.add(new Product(
                Long.valueOf(2),
                "Laptop",
                BigDecimal.valueOf(10000),
                new Category(Long.valueOf(1), "technology"),
                "Nice laptop",
                Long.valueOf(100)
        ));
        return this.products;
    }

    // A method to find a product by its id.
    // If product does not exist, then the function will return null. Otherwise it will return the desired product.
    @Override
    public Product findById(Long id) {
        List<Product> data = this.products.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
        if(data.size() == 0) {
            return null;
        }
        return data.get(0);

    }

    // A function to add a product to product list defined above.
    // Function prints a message to the console, which specify that product is added.
    @Override
    public void add(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

}
