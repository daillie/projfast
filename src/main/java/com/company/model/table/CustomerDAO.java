package com.company.model.table;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dba.HibernateUtil;
import com.company.model.Customer;
import com.company.sql.DataSource;
import org.hibernate.Session;

public class CustomerDAO implements DataAccessObject<Customer> {
    private static final String GET_ALL_QUERY = "select * from Customer order by id";

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customers;
    }

    public Customer getById(Long id) {
        return null;
    }

    public boolean insert(Customer customer) {
//        try {
//            PreparedStatement ps = DataSource.getConnection()
//                    .prepareStatement("insert into Customer (first_name,last_name,type_id,address,num,fax_num) values (?,?,?,?,?,?)");
//            ps.setString(1, customer.getFirstName());
//            ps.setString(2, customer.getLastName());
//            ps.setInt(3, customer.getTypeId());
//            ps.setString(4, customer.getAddress());
//            ps.setString(5, customer.getNum());
//            ps.setString(6, customer.getFaxNum());
//            return ps.executeUpdate() == 1 ? true : false;
//        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//        }

        return false;
    }
}
