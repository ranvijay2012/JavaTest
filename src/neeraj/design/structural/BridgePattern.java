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






