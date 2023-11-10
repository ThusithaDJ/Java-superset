package annotations;

import annotations.model.MyComponentClass;
import annotations.myannotations.MyAutowired;

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
