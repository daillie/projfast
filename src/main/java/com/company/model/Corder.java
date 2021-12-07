package com.company.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "C_order")
public class Corder extends EntityAbstract {

    // id int auto_increment primary key,
    // customer_id int ,
    // typography_id int,
    // acceptance_date date,
    // completion_date date,
    // completed boolean,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "publication_id")
    private int publicationId;
    @Column(name = "cost")
    private int cost;
    @Column(name = "acceptance_date")
    private Date acceptanceDate;
    @Column(name = "completion_date")
    private Date completionDate;
    @Column(name = "completed")
    private boolean completed;

    public static final String TABLE_NAME = "C_order";

    public Corder() {
    }

    public Corder(int id, int customerId, int publicationId, Date acceptanceDate, Date completionDate, boolean completed) {
        this.id = id;
        this.customerId = customerId;
        this.publicationId = publicationId;
        this.acceptanceDate = acceptanceDate;
        this.completionDate = completionDate;
        this.completed = completed;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPublicationId() {
        return this.publicationId;
    }

    public void setPublicationId(int typographyId) {
        this.publicationId = typographyId;
    }

    public Date getAcceptanceDate() {
        return this.acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public Date getCompletionDate() {
        return this.completionDate;
    }

    public void setCompletionDate(Date completetionDate) {
        this.completionDate = completetionDate;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Corder)) return false;
        Corder corder = (Corder) o;
        return id == corder.id && customerId == corder.customerId && publicationId == corder.publicationId &&
                cost == corder.cost && completed == corder.completed &&
                Objects.equals(acceptanceDate, corder.acceptanceDate) &&
                Objects.equals(completionDate, corder.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, publicationId, cost, acceptanceDate, completionDate, completed);
    }
}
