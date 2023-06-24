package dto;


import java.math.BigDecimal;

public class CreateProductRequest {

    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private Long categoryId;
    private String description;
    private Long unitsInStock;

    public CreateProductRequest(Long id, String name, BigDecimal unitPrice, Long categoryId, String description, Long unitsInStock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
        this.description = description;
        this.unitsInStock = unitsInStock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }
}
