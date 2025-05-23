package neeraj.design.structural;

public class AdapterPattern {
    public static void main(String[] args) {
        OldPrinter legacyPrinter = new OldPrinter();

        // Using adapter to integrate OldPrinter into new system
        Printable adaptedPrinter = new PrinterAdapter(legacyPrinter, "Hello, Adapter Pattern!");

        adaptedPrinter.print(); // Client uses Printable, unaware of OldPrinter
    }
}

class OldPrinter {
    public void printText(String text) {
        System.out.println("OldPrinter: " + text);
    }
}


interface Printable {
    void print();
}


class PrinterAdapter implements Printable {
    private OldPrinter oldPrinter;
    private String text;

    public PrinterAdapter(OldPrinter oldPrinter, String text) {
        this.oldPrinter = oldPrinter;
        this.text = text;
    }

    @Override
    public void print() {
        oldPrinter.printText(text); // Delegates call to the adaptee
    }
}

/*

The Adapter Design Pattern is a structural pattern used to allow incompatible interfaces to work together.
It acts as a bridge between two incompatible interfaces.

✅ When to Use
When you need to use an existing class, but its interface doesn’t match your requirements.
When you want to integrate a legacy class into a modern system.

🧩 Benefits
Allows reuse of existing functionality.
Promotes loose coupling.
Helps integrate legacy code into modern applications.

⚠️ Drawbacks
Adds a layer of abstraction.
Can become complex if too many adapters are used.
 */