import dto.CreateProductRequest;
import dto.ProductDto;
import dto.ProductDtoConverter;
import repository.CategoryRepository;
import repository.ProductRepository;
import service.CategoryService;
import service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService(
                new ProductRepository(),
                new ProductDtoConverter(),
                new CategoryService(new CategoryRepository())
        );

        int choice = 0; // initially 0
        while(choice !=4) {
            System.out.println("1-Create Product");
            System.out.println("2-Find product by its id");
            System.out.println("3-List all products");
            System.out.println("4-Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // This adds a product defined below.
                    CreateProductRequest request = new CreateProductRequest(
                            Long.valueOf(1),
                            "Mobile Phone",
                            BigDecimal.valueOf(2000),
                            Long.valueOf(1),
                            "Mobile phone description",
                            Long.valueOf(100)
                    );
                    productService.add(request);
                    break;
                case 2:
                    // prints the product information whose id 1
                    // Initially no product exists with id 1. case 1 add this product
                    // If the product whose id is 1 is not added to product list defined in product repository, this method prints error message to the console.
                    ProductDto product =  productService.findProductById(Long.valueOf(1));
                    if(product == null) {
                        System.out.println("No product found with id: 1");
                    }
                    else {
                        // If product whose id is 1 is added to product list defined in product repository. this prints some information about the product.
                        System.out.println("Id: " + product.getId());
                        System.out.println("Name: " + product.getName());
                        System.out.println("Price: " + product.getUnitPrice().toString());
                        System.out.println("Category name: " + product.getCategory().getName());
                        System.out.println("Units in stock: " + product.getUnitsInStock());
                    }
                    break;
                case 3:
                    // this prints all products defined in product repository.
                    // Initially one product added.
                    List<ProductDto> products = productService.findAll();
                    products.forEach(item -> {
                        System.out.println("Id: " + item.getId());
                        System.out.println("Name: " + item.getName());
                        System.out.println("Price: " + item.getUnitPrice().toString());
                        System.out.println("Category name: " + item.getCategory().getName());
                        System.out.println("Units in stock: " + item.getUnitsInStock());
                        System.out.println("-------------------");
                    });
                    break;
                case 4:
                    // This is used to exist the program.
                    System.out.println("Quit...");
                    System.exit(1);
                    break;
                default:
                    // If the user enter the invalid choice, this prints error message to the console.
                    System.out.println("Invalid choice.");
                    break;

            }
        }


        scanner.close();

    }

}