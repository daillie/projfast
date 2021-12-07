package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Publication")
public class Publication extends EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_id")
    private int productID;
    @Column(name = "typography_id")
    private int typographyId;
    @Column(name = "amount_pages")
    private int amountPages;
    @Column(name = "circulation")
    private int circulation;

    public Publication(int id, int productID, int typographyId, int amountPages, int circulation) {
        this.id = id;
        this.productID = productID;
        this.typographyId = typographyId;
        this.amountPages = amountPages;
        this.circulation = circulation;
    }

    public Publication() {
    }

    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAmountPages() {
        return this.amountPages;
    }

    public void setAmountPages(int amountPages) {
        this.amountPages = amountPages;
    }

    public int getCirculation() {
        return this.circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypographyId() {
        return typographyId;
    }

    public void setTypographyId(int typographyId) {
        this.typographyId = typographyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return id == that.id && productID == that.productID && typographyId == that.typographyId &&
                amountPages == that.amountPages && circulation == that.circulation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productID, typographyId, amountPages, circulation);
    }
}
