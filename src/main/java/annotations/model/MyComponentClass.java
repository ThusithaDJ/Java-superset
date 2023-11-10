package annotations.model;

import annotations.myannotations.MyComponent;

@MyComponent
public class MyComponentClass {

    public void printClassName() {
        System.out.println(this.getClass().getName());
    }
}
