package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Product_type")
public class ProductType extends EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_title")
    private String productTitle; // 16c

    public ProductType() {
    }

    public ProductType(int id, String productTitle) {
        this.id = id;
        this.productTitle = productTitle;
    }

    public String getProductTitle() {
        return this.productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductType)) return false;
        ProductType that = (ProductType) o;
        return id == that.id && Objects.equals(productTitle, that.productTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productTitle);
    }
}
