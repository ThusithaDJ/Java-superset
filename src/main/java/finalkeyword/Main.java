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

}
