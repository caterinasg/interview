package com.meldinh.recreatedi;

import com.meldinh.recreatedi.controller.external.TableController;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {

    /**
     * Test Table
     * todo add more test
     */
    @Test
    public void TestIntegrity() {
        TableController controller = new TableController();
        Integer id1 = 01;
        Integer id2 = 02;
        String value1 = "abc";
        String value2 = "xyz";
        controller.post(id1, value1);
        String v1 = controller.get(id1);
        assertTrue(v1.startsWith("200"));
        assertTrue(v1.endsWith(value1));
        controller.post(id2, value1);
        String v2 = controller.get(id2);
    }
}
