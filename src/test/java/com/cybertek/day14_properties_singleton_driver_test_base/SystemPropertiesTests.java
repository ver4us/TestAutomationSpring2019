package com.cybertek.day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;

public class SystemPropertiesTests {


    @Test
    public void systemPropertiesTest1(){
        String os = System.getProperty("os.name");
        System.out.println(os);
    }
}
