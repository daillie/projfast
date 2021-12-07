package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Customer_type")
public class CustomerType extends EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type_name")
    private String typeName;

    CustomerType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public CustomerType() {

    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        if (!(o instanceof CustomerType)) return false;
        CustomerType that = (CustomerType) o;
        return id == that.id && Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName);
    }


}
