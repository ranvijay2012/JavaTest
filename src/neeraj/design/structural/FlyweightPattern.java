package neeraj.design.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightPattern {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public static void main(String[] args) {
        FlyweightPattern forest = new FlyweightPattern();
        forest.plantTree(10, 20, "Oak", "Green", "Rough");
        forest.plantTree(15, 25, "Oak", "Green", "Rough");
        forest.plantTree(30, 40, "Pine", "Dark Green", "Smooth");

        forest.draw();
    }
}

class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ")");
    }
}

class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        TreeType result = treeTypes.get(key);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(key, result);
        }
        return result;
    }
}

class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}


/*
The Flyweight Design Pattern is a structural design pattern that focuses on minimizing memory usage by
sharing as much data as possible with similar objects. It is particularly useful when dealing with
large numbers of objects that share common data.

🧠 Key Concepts
Intrinsic State: Shared data that is common across many objects (stored in the flyweight object).
Extrinsic State: Data that is unique to each instance and must be passed in during method calls
(not stored in the flyweight object).
Flyweight Factory: Manages a pool of shared flyweight objects.

✅ When to Use
You have a large number of objects.
Object instantiation is costly in terms of memory or performance.
Many of those objects share identical data.

🧩 Benefits
Reduces memory consumption.
Improves performance in scenarios with many similar objects.
⚠️ Drawbacks
Code complexity increases.
You must carefully manage extrinsic state.


 */




