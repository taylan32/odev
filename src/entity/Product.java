package entity;

import java.math.BigDecimal;

public class Product extends BaseEntity {

    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private Category category;
    private String description;
    private Long unitsInStock;

    public Product(Long id, String name, BigDecimal unitPrice, Category category, String description, Long unitsInStock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }
}
