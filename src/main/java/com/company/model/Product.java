package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product extends EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "product_name")
    private String productName; // 32c

    public Product(int id, int typeId, String productName) {
        this.id = id;
        this.typeId = typeId;
        this.productName = productName;
    }

    public Product() {
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && typeId == product.typeId && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId, productName);
    }
}
