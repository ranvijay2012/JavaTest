package neeraj.design.structural;

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

/*
The Decorator Design Pattern is a structural design pattern that lets you dynamically add behavior to an object
 without altering its structure. It's perfect for situations where subclassing would lead to a combinatorial
 explosion of classes.

🧠 Key Concepts
Component: Interface or abstract class (e.g., Coffee)
ConcreteComponent: A base implementation (e.g., SimpleCoffee)
Decorator: Abstract class implementing Coffee, holding a reference to another Coffee
ConcreteDecorators: Add extra behavior (e.g., MilkDecorator, SugarDecorator)

🧩 Benefits
Adds behavior without altering original class.
Follows Open/Closed Principle.
Promotes composition over inheritance.

⚠️ Drawbacks
Can result in many small classes.
Debugging can be harder with many layers.
 */


