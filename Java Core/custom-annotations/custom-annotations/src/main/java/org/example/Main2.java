package org.example;

import org.example.model.MyComponentClass;
import org.example.myannotations.MyAutowired;

import java.util.Objects;

public class Main2 {

    @MyAutowired
    public static MyComponentClass myComponentClass;

    public void printMyComponentClassName() {
        if (Objects.nonNull(myComponentClass)) {
            myComponentClass.printClassName();
        } else  {
            System.out.println("MyCompoentClass Is null");
        }
    }
}
