package neeraj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("neeraj.Emp");

//        Constructor array
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("Name of Constructor : " + constructor);
            System.out.println("Count constructor Parameter:" + constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor's parameter : " + parameter);
            }
            System.out.println();
        }
        System.out.println();
//          Method Array

        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("Length of method : " + declaredMethods.length);

        for (Method method : declaredMethods) {
            System.out.println("Method name: \t" + method);
            System.out.println("Method return type : \t" + method.getReturnType());
            System.out.println("Method parameter count: \t" + method.getParameterCount());
            System.out.println();
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method's Parameter : " + parameter);
            }
            System.out.println();
        }
        System.out.println();
//        Annotations
        Class[] classes = clazz.getDeclaredClasses();
        for (Class class1 : classes) {
            System.out.println("class: " + class1);
            System.out.println("Name of class: " + class1.getName());
        }
        System.out.println("-----------------");

//        Annotations
        Annotation[] anno = clazz.getDeclaredAnnotations();
        for (Annotation annotation : anno) {
            System.out.println("Annotation: " + annotation);
        }

    }
}

class Emp {
    private int eid;
    private double esal;
    private String ename;

    enum Week {
        SUN, TUE, WED;
    }

    @interface MyAnno {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid, int num, char ch) {
        this.eid = eid;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal, float data, String name) {
        this.esal = esal;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    // constructor
    public Emp(int eid, double esal, String ename) {
        super();
        this.eid = eid;
        this.esal = esal;
        this.ename = ename;
    }

    Emp() {
    }

    class A {
    }

    class B {
    }
}