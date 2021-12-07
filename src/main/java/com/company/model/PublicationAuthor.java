package com.company.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Publication_Author")
public class PublicationAuthor extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "publication_id")
    private int publictaionId;
    @Column(name = "author_id")
    private int authorId;


    public PublicationAuthor() {
    }


    public int getPublictaionId() {
        return this.publictaionId;
    }

    public void setPublictaionId(int publictaionId) {
        this.publictaionId = publictaionId;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "PublicationAuthor{" +
                "id=" + id +
                ", publictaionId=" + publictaionId +
                ", authorId=" + authorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicationAuthor)) return false;
        PublicationAuthor that = (PublicationAuthor) o;
        return id == that.id && publictaionId == that.publictaionId && authorId == that.authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publictaionId, authorId);
    }
}
