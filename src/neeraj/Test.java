package neeraj;

import com.sun.tools.javac.Main;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();

        System.out.println("ClassLoader: " + classLoader);
        System.out.println("Parent: " + classLoader.getParent());
        System.out.println("Grandparent (bootstrap): " + classLoader.getParent().getParent());
    }
}