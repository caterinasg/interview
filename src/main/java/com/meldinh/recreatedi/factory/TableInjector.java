package com.meldinh.recreatedi.factory;

import com.meldinh.recreatedi.client.TableClient;
import com.meldinh.recreatedi.client.impl.TableClientImpl;
import com.meldinh.recreatedi.persistence.service.TableService;
import com.meldinh.recreatedi.persistence.service.impl.TableServiceImpl;

import java.util.concurrent.ConcurrentHashMap;

public class TableInjector {
    private ConcurrentHashMap<String, Object> map;

    private TableInjector() {
        map = new ConcurrentHashMap<String, Object>();

    }

    /**
     * Get the Java session's instance of this class
     * @return The only instance of the Injector
     */
    public static TableInjector getInstance() {
        return new TableInjector();
    }

    /**
     * Get new instance for a class/interface or retrieve existing one if exist
     * @param T class for which new instance need to be created
     * @param <T> see above
     * @return Instance object of class T
     */
    public <T>Object getData(Class T) {
        if (T == null)
            throw new NullPointerException();
        if (map.containsKey(T.toString()))
            return (T)map.get(T.toString());
        else
            return getNewData(T);
    }

    private <T>Object getNewData(Class T) {
        if (T.isInterface()) {
            if (T.isAssignableFrom(TableService.class)) {
                return (T) (new TableServiceImpl());
            } else if (T.isAssignableFrom(TableClient.class)) {
                return (T) (new TableClientImpl());
            } else
                return null;
        } else {
            try {
                return T.newInstance();
            } catch (Exception ex) {
                return null;
            }
        }
    }
}
