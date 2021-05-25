package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWordTest {
    int a = 4;
    int b = 9;
    @Before
    public void setUp() throws Exception {
        System.out.println(" @Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println(" @After");
    }

    @Test
    public void main() {
        System.out.println("Hello World");
    }

    @Test
    public void hello() {
        int c = a+b;
        System.out.println(c);
    }
}