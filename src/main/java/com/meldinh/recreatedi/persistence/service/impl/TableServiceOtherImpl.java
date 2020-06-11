package com.meldinh.recreatedi.persistence.service.impl;

import com.meldinh.recreatedi.persistence.model.Table;
import com.meldinh.recreatedi.persistence.service.TableService;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Just to demonstrate another TableService implementation to be injected
 **/
public class TableServiceOtherImpl implements TableService {
    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap();

    @Override
    public ArrayList<Table> findAll() {
        return new ArrayList<Table>(map.entrySet()
                .stream()
                .map(entry -> new Table(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList()));
    }

    @Override
    public Table findById(Integer id) {
        if (map.containsKey(id))
            return new Table(id, map.get(id));
        else
            return null;
    }

    @Override
    public boolean update(Integer id, String value) {
        if (map.containsKey(id)) {
            map.put(id, value);
            return true;
        } else {
            map.put(id, value);
            return false;
        }
    }
}
