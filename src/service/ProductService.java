package service;

import dto.CreateProductRequest;
import dto.ProductDto;
import dto.ProductDtoConverter;
import entity.Category;
import entity.Product;
import repository.IProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private IProductRepository productRepository;
    private ProductDtoConverter converter;
    private CategoryService categoryService;

    public ProductService(IProductRepository productRepository,
                          ProductDtoConverter converter,
                          CategoryService categoryService) {
        this.productRepository = productRepository;
        this.converter = converter;
        this.categoryService = categoryService;
    }

    // A method to list all categories
    // The method lists all existing products converting product to product dto
    public List<ProductDto> findAll() {
        return this.productRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    // A method to add product
    public void add(CreateProductRequest request) {
        Category category = this.categoryService.findById(request.getCategoryId());
        Product product = new Product(
                request.getId(),
                request.getName(),
                request.getUnitPrice(),
                category,
                request.getDescription(),
                request.getUnitsInStock()

        );
        this.productRepository.add(product);
    }

    // a method to find the product by its id.
    // This method covert the product to product dto.
    public ProductDto findProductById(Long id) {
        Product product = findById(id);
        if(product == null ){
            return null;
        }
        return converter.convert(findById(id));
    }

    // a method to find the product by its id.
    // protected method to prevent from accessing outside of the class
    protected Product findById(Long id) {
        return this.productRepository.findById(id);
    }





}
