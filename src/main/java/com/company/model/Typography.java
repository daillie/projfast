package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Typography")
public class Typography extends EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "typography_name")
    private String typographyName; // 16c
    @Column(name = "address")
    private String address; // 64c
    @Column(name = "num")
    private String num; // 15c

    public Typography() {

    }

    public Typography(int id, String typographyName, String address, String num) {
        this.id = id;
        this.typographyName = typographyName;
        this.address = address;
        this.num = num;
    }

    public String getTypographyName() {
        return this.typographyName;
    }

    public void setTypographyName(String typographyName) {
        this.typographyName = typographyName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
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
        if (!(o instanceof Typography)) return false;
        Typography that = (Typography) o;
        return id == that.id && Objects.equals(typographyName, that.typographyName) &&
                Objects.equals(address, that.address) && Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typographyName, address, num);
    }

    @Override
    public String toString() {
        return "Typography{" +
                "id=" + id +
                ", typographyName='" + typographyName + '\'' +
                ", address='" + address + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
