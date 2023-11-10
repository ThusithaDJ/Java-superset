package annotations;


import annotations.model.Child2;
import annotations.model.MyComponentClass;
import annotations.model.SuperClass;
import annotations.myannotations.MyAutowired;
import annotations.myannotations.MyComponent;
import annotations.myannotations.MyFieldAnnotation;
import annotations.myannotations.MyFistAnnotation;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    @MyFieldAnnotation
    private SuperClass fieldAnnotation;

    @MyAutowired
    private static MyComponentClass myComponentClass;

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

        /**
         * Inject child object to the fieldAnnotation variable.
         */
        Main fieldObj = new Main();
        for (Field field : Main.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyFieldAnnotation.class)) {
                try {
                    field.set(fieldObj, new Child2());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        if (Objects.nonNull(fieldObj.fieldAnnotation)) {
            fieldObj.fieldAnnotation.currentClass();
        } else {
            System.out.println("Field annotation is Null");
        }


        /**
         * Implementing similar to Spring dependency inject using Java reflection.
         * Created {@link MyAutowired} annotation to identify static fields needed to get dependency injected.
         * Create {@link MyComponent} annotation to configure class that are candidate for the dependency injection.
         *
         */
        Reflections reflections = new Reflections("org.example.",new SubTypesScanner(false));
        Set<Class<? extends Object>> collect = reflections.getSubTypesOf(Object.class).stream().collect(Collectors.toSet());

        for (Class<? extends Object> aClass : collect) {
            if (aClass.isAnnotationPresent(MyComponent.class)) {
                for (Class<? extends Object> aClass1 : collect) {
                    for (Field declaredField : aClass1.getDeclaredFields()) {
                        if (declaredField.isAnnotationPresent(MyAutowired.class)) {
                            try {
                                // Since the myComponent variable is a static variable
                                declaredField.set(null, aClass.newInstance());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        }

        if (Objects.nonNull(myComponentClass)) {
            myComponentClass.printClassName();
            System.out.println("Calling Main2 printMyComponentClassName method");
            new Main2().printMyComponentClassName();
        } else {
            System.out.println("My component class is Null");
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