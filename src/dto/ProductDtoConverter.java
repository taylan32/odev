package dto;

import entity.Product;

public class ProductDtoConverter {

    //a method to convert the product object to product dto
    public ProductDto convert(Product from) {
        return new ProductDto(
                from.getId(),
                from.getName(),
                from.getUnitPrice(),
                from.getCategory(),
                from.getDescription(),
                from.getUnitsInStock()
        );
    }
}
