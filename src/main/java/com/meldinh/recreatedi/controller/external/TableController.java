package com.meldinh.recreatedi.controller.external;

import com.meldinh.recreatedi.cache.TableInjector;
import com.meldinh.recreatedi.controller.exception.RecreateDIException;
import com.meldinh.recreatedi.persistence.service.TableService;

public class TableController {

    static TableService service;

    static {
        service = (TableService) TableInjector.getInstance().getData(TableService.class);
    }

    /**
     * Post content
     * @param id
     * @param value
     * @return 200 true if update existing content,
     * 200 false if new content
     * 500 plus details if exception
     */
    public String post(Integer id, String value) {
        try {
            return "200 " + service.update(id, value);
        } catch (RuntimeException ex) {
            return "500 " + new RecreateDIException();
        }
    }

    /**
     * Retrieve content
     * @param id
     * @return 200 + content based on id, 500 if exception
     */
    public String get(Integer id) {
        try {
            return "200 " + service.findById(id).getValue();
        } catch (RuntimeException ex) {
            return "500 " + new RecreateDIException();
        }
    }

    /**
     * Delete content
     * @param id
     * @return 200 if success 500 if exception
     * todo
     */
    public String delete(Integer id) {
        return "500 " + new UnsupportedOperationException();
    }
}
