package com.meldinh.recreatedi.client.impl;

import com.meldinh.recreatedi.client.TableClient;
import com.meldinh.recreatedi.controller.external.TableController;
import com.meldinh.recreatedi.factory.TableInjector;
import com.meldinh.recreatedi.persistence.service.TableService;
import com.meldinh.recreatedi.persistence.service.impl.TableServiceOtherImpl;

public class TableClientImpl implements TableClient {


    @Override
    public void setService(TableController tableController) {
        TableService
                service = (TableService) TableInjector.getInstance().getData(TableService.class);
        tableController.setService(service);
    }

    @Override
    public void setOtherService(TableController tableController) {
        TableService
                service = (TableService) TableInjector.getInstance().getData(TableServiceOtherImpl.class);
        tableController.setService(service);
    }
}
