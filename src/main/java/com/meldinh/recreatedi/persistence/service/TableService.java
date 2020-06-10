package com.meldinh.recreatedi.persistence.service;

import com.meldinh.recreatedi.persistence.model.Table;

import java.util.ArrayList;

/**
 * @author Mel
 * Service to get data from a table
 */
public interface TableService {

    /**
     *
     * @return all rows from DB
     */
    public ArrayList<Table> findAll();

    /**
     *
     * @param id the row's key
     * @return the row from DB based on key
     */
    public Table findById(Integer id);

    /**
     *
     * @param id the row's key
     * @param value the row's data
     * @return save to db result, true if it's update, false if it's insert
     */
    public boolean update(Integer id, String value);
}
