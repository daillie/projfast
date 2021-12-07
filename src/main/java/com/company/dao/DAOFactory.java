package com.company.model.table;

import com.company.model.*;

import java.io.Serializable;

public class DAOFactory {
    /***
     * CRINGE
     * @param tableName name of table
     * @return shitpost
     */
    public static AbstractDAO<?> getDaoByTableName(String tableName) {
        AbstractDAO dao = null;
        if ("Author".equals(tableName)) {
            dao = new AbstractDAO<Author>();
            dao.setClazz(Author.class);
        } else if ("C_order".equals(tableName)) {
            dao = new AbstractDAO<Corder>();
            dao.setClazz(Corder.class);
        } else if ("Customer".equals(tableName)) {
            dao = new AbstractDAO<Customer>();
            dao.setClazz(Customer.class);
        } else if ("Customer_type".equals(tableName)) {
            dao = new AbstractDAO<CustomerType>();
            dao.setClazz(CustomerType.class);
        } else if ("Product".equals(tableName)) {
            dao = new AbstractDAO<Product>();
            dao.setClazz(Product.class);
        } else if ("Product_type".equals(tableName)) {
            dao = new AbstractDAO<ProductType>();
            dao.setClazz(ProductType.class);
        } else if ("Publication".equals(tableName)) {
            dao = new AbstractDAO<Publication>();
            dao.setClazz(Publication.class);
        } else if ("Publication_Author".equals(tableName)) {
            dao = new AbstractDAO<PublicationAuthor>();
            dao.setClazz(PublicationAuthor.class);
        } else if ("Typography".equals(tableName)) {
            dao = new AbstractDAO<Typography>();
            dao.setClazz(Typography.class);
        }

        return dao;
    }
}
