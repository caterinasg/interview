package com.meldinh.recreatedi.client;

import com.meldinh.recreatedi.controller.external.TableController;

public interface TableClient {

    public void setService(TableController tableController);

    public void setOtherService(TableController tableController);
}
