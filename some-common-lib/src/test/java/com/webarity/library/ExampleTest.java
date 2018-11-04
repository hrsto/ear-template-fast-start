package com.webarity.library;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webarity.library.Example;

public class ExampleTest{
    
    @Test
    @DisplayName("test")
    void firstTest(){
        assertEquals(new Example().getHellow().compareTo("\\o"), 0);
    }
}