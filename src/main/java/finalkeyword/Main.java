package finalkeyword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FinalObject obj = new FinalObject("name", 22);
        System.out.println(obj);

    }




    /**
     * The compiler with will give a 'cannot inherit from final FinalObject' compile time exception. Since the FinalObject
     * class is an immutable object since it has the final keyword.
     */
    /*
    class ChildOfFinalObject extends FinalObject {

        *//**
         * Since FinalObject do not have a default constructor it is necessory to implement a parameterized constructor.
         * Why?
         *      Since in java when we extend a class, when it's initializing it call super classes constructor all
         *      upto object class to initialize the lowest child class.
         *      Since the FinalObject class do not have a default constructor in ChildOfFinalObject need to implement the parameterized constructor.
         * @param name
         * @param age
         *//*
        public ChildOfFinalObject(String name, int age) {
            super(name, age);
        }
    }
    */


    static class ClassWithFinalMethod {

        public final void finalMethod() {
            System.out.println("Printing from finalMethod of ClassWithFinalMethod class");
        }
    }

    static class Child1ofClassWithFinalMethod extends ClassWithFinalMethod {

        /**
         * This will throw overridden method is final compile time exception. In the {@link ClassWithFinalMethod}
         * class' finalMethod it has the final keyword in it's method.
         *
         */
        /*@Override
        public void finalMethod() {
            super.finalMethod();
        }*/
    }

    interface interfaceWithFinalMethod {

        /**
         * Final keyword is not allowed here. Because in interfaces there is no implementation for the methods.
         * So whichever class that implements this interface has to orverride and provide an implementation for it.
         * Using final keyword in a method inside an interfaces it's not allowed.
         */
        /*public final void finalInterfaceMethod();*/


    }

}
