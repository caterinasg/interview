package com.meldinh.recreatedi;

import com.meldinh.recreatedi.client.TableClient;
import com.meldinh.recreatedi.client.impl.TableClientImpl;
import com.meldinh.recreatedi.controller.external.TableController;
import com.meldinh.recreatedi.factory.TableInjector;
import com.meldinh.recreatedi.persistence.service.TableService;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {

    /**
     * Test Table
     * todo add more test
     */
    @Test
    public void TestIntegrity() {
        TableClient tableClient =
                (TableClient) TableInjector.getInstance().getData(TableClient.class);

        TableController controller = new TableController();
        tableClient.setService(controller);
        Integer id1 = 01;
        String value1 = "abc";
        controller.post(id1, value1);
        String v1 = controller.get(id1);
        assertTrue(v1.startsWith("200"));
        assertTrue(v1.endsWith(value1));

        tableClient.setOtherService(controller);
        String v = controller.get(id1);
        assertFalse(v.startsWith("200"));
        assertFalse(v.endsWith(value1));
        Integer id2 = 02;
        String value2 = "xyz";
        controller.post(id2, value2);
        String v2 = controller.get(id2);
        assertTrue(v2.startsWith("200"));
        assertTrue(v2.endsWith(value2));
    }
}
