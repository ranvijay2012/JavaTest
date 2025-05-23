package neeraj.design.behavioral;

public class VisitorPattern {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
                new Book(20, "Design Patterns"),
                new Fruit(2, 5, "Apple")
        };

        Visitor visitor = new ShoppingCartVisitorImpl();
        for (ItemElement item : items) {
            item.accept(visitor);
        }
    }
}

// 1. Visitor Interface
interface Visitor {
    void visit(Book book);

    void visit(Fruit fruit);
}

// 2. Concrete Visitor
class ShoppingCartVisitorImpl implements Visitor {
    public void visit(Book book) {
        int cost = book.getPrice();
        System.out.println("Book: " + book.getName() + " Cost = $" + cost);
    }

    public void visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println("Fruit: " + fruit.getName() + " Cost = $" + cost);
    }
}

// 3. Element Interface
interface ItemElement {
    void accept(Visitor visitor);
}

// 4. Concrete Elements
class Book implements ItemElement {
    private int price;
    private String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int priceKg, int weight, String name) {
        this.pricePerKg = priceKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


/*
📦 Intent
"Represent an operation to be performed on the elements of an object structure.
Visitor lets you define a new operation without changing the classes of the elements on which it operates."

✅ Use Cases
You want to perform different operations across a set of objects with different classes.
You need to add new operations without modifying the object structure.
You’re working with a complex object structure like a composite tree.

🧠 Key Components
Visitor: Declares visit methods for each type of element.
ConcreteVisitor: Implements each visit method.
Element: Interface with an accept(Visitor v) method.
ConcreteElement: Implements accept and calls back the visitor.
ObjectStructure: Collection of elements that can be iterated over.

✅ Advantages
Easily add new operations without changing element classes.
Promotes Open/Closed Principle.
Clean separation of concerns.

❌ Disadvantages
Harder to add new element types (you must change every Visitor).
Breaks encapsulation if visitors rely on internal details of elements.
 */
