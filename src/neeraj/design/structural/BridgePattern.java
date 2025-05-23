package neeraj.design.structural;

public class BridgePattern {
    public static void main(String[] args) {
        Shape circle1 = new CircleShape(1, 2, 3, new DrawingAPI1());
        Shape circle2 = new CircleShape(5, 7, 11, new DrawingAPI2());

        circle1.resizeByPercentage(2.5);
        circle2.resizeByPercentage(0.5);

        circle1.draw();
        circle2.draw();
    }
}

interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
}

class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.println("API1.circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.println("API2.circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw(); // low-level
    public abstract void resizeByPercentage(double pct); // high-level
}

class CircleShape extends Shape {
    private double x, y, radius;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    public void resizeByPercentage(double pct) {
        radius *= pct;
    }
}

/*
The Bridge Design Pattern is a structural design pattern that decouples an abstraction from its implementation
so that the two can vary independently. It's useful when you want to avoid a combinatorial explosion of
classes due to multiple dimensions of change.

🧠 Key Concepts
Abstraction: The high-level control layer (interface or abstract class).
Implementor: The low-level interface (the implementation layer).
Bridge: The abstraction contains a reference to the implementor.
Refined Abstraction: A subclass of the abstraction that interacts with the implementor.

✅ When to Use
When you want to separate abstraction and implementation permanently.
When you have multiple variants of abstraction and implementation.
To avoid deep inheritance hierarchies.

🧩 Benefits
Decouples interface from implementation.
Increases flexibility and scalability.
Reduces subclass explosion.

⚠️ Drawbacks
Adds complexity via indirection.
Can be overkill for simple hierarchies.
 */




