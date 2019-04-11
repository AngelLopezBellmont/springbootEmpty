package com.hemmersbach.springbootEmpty.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyFirstTestTest{

    @Test
    public void test1() {
        String name  = "hallo";
        assertNotNull (name);

    }
}
