package com.company.model;

import java.lang.reflect.Field;

public abstract class EntityAbstract {

    protected EntityAbstract() {

    }

    public String[] getFieldValuesAsStringArray() {
        Field[] fields = this.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        try {
            for (int i = 0; i < fields.length; i++) {
                fieldNames[i] = fields[i].get(this).toString();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldNames;
    }
}
