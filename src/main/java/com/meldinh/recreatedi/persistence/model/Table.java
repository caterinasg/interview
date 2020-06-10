package com.meldinh.recreatedi.persistence.model;

import java.util.Objects;

/**
 * model of a table
 */
public class Table {

    public Integer id;
    public String value;

    public Table(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(id, table.id) &&
                Objects.equals(value, table.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, value);
    }
}
