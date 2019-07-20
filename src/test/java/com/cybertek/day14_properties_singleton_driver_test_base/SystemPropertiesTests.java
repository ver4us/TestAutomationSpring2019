package com.cybertek.day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;
import java.util.*;
public class SystemPropertiesTests {


    @Test
    public void systemPropertiesTest1(){
//        String os = System.getProperty("os.name");
//        String username = System.getProperty("user.name");
//        String javaVersion = System.getProperty("java.specification.version");
//        //String  = System.getProperty("os.name");
//        System.out.println(os);
//        System.out.println(username);
//        System.out.println(javaVersion);
//        System.out.println(os);
//        System.out.println(os);
//        System.out.println(os);
//        System.out.println(os);

        String os = System.getProperty("os.name");
        System.out.printf(os);
        String username= System.getProperty("user.name");
        String javaVersion = System.getProperty("java.version");
        String homeDirectory = System.getProperty("user.home");
        System.out.println(os);
        System.out.println(username);
        System.out.println(javaVersion);
        System.out.println(homeDirectory);
        Properties properties =System.getProperties();
        // this is an enttry set of all properties
        for (Map.Entry<Object,Object> property : properties.entrySet()) {
            System.out.println("Key: " + property.getKey() + " Value :" + property.getValue());
        }

    }
}
