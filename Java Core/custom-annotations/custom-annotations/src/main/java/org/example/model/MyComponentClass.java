package org.example.model;

import org.example.myannotations.MyComponent;

@MyComponent
public class MyComponentClass {

    public void printClassName() {
        System.out.println(this.getClass().getName());
    }
}
