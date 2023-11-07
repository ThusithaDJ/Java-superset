package org.example;

import org.example.myannotations.MyFistAnnotation;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");


        /**
         * Execute only the instance methods decorated with {@link MyFistAnnotation} annotation.
         */
        Main main = new Main();
        for (Method m : main.getClass().getMethods()) {
            if (m.isAnnotationPresent(MyFistAnnotation.class)) {
                try {
                    m.invoke(main);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        /**
         * This will trigger both static and instance methods decorated with {@link MyFistAnnotation} annotation.
         * Because, Main.class.getDeclaredMethods() returns all the methods.
         * So when m.invoke(new Main()) method call, it'll first execute the static method and then execute the instance method.
         */
        for(Method m : Main.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyFistAnnotation.class)) {
                try {
                    m.invoke(new Main());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @MyFistAnnotation
    public void shouldTriggeredFromAnnotation() {
        System.out.println("Triggered from annotation");
    }

    @MyFistAnnotation
    static void staticMethodShouldTriggeredFromAnnotation() {
        System.out.println("Static method triggered from annotation");
    }
}