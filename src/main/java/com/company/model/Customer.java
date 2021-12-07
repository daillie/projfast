package com.company.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "address")
    private String address;
    @Column(name = "num")
    private String num;
    @Column(name = "fax_num")
    private String faxNum;


    public Customer(int id, String firstName, String lastName, int typeId, String address, String num, String faxNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeId = typeId;
        this.address = address;
        this.num = num;
        this.faxNum = faxNum;
    }

    public Customer() {

    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public String getFaxNum() {
        return this.faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id && typeId == customer.typeId && Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address) &&
                Objects.equals(num, customer.num) && Objects.equals(faxNum, customer.faxNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, typeId, address, num, faxNum);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", typeId=" + typeId +
                ", address='" + address + '\'' +
                ", num='" + num + '\'' +
                ", faxNum='" + faxNum + '\'' +
                '}';
    }

    @Override
    public String[] getFieldValuesAsStringArray() {
        Field[] fields = Customer.class.getDeclaredFields();
        String[] fieldValues = new String[fields.length];
        try {
            for (int i = 0; i < fields.length; i++) {
                Object obj = fields[i].get(this);
                fieldValues[i] = obj == null ? "NULL" : obj.toString();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldValues;
    }


}
