package com.company.model.table;

import com.company.dba.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class AbstractDAO<T extends Serializable> {
    private Class<T> clazz;

    public void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return (T) HibernateUtil.getSessionFactory().openSession().get(clazz, id);
    }

    public List<T> findAll() {
        return HibernateUtil.getSessionFactory().openSession().createQuery("from " + clazz.getName()).list();
    }
}
