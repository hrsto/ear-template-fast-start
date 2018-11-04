package com.webarity.ejbModule;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SomeEjbTest {

    @Test
    @DisplayName("test")
    void firstTest() {
        SomeEJBContract ejb = new SomeEJBImpl();
        assertEquals(Arrays.compare(ejb.pong("qwe"), "pong: qwe \\o\n".getBytes()), 0);
    }
}