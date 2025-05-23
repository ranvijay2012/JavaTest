package neeraj.design.structural;

public class StatePattern {
    public static void main(String[] args) {
        DocumentContext document = new DocumentContext();
        document.applyState(); // Output: Document is in read-only mode.

        document.setState(new EditingState());
        document.applyState(); // Output: Document is in editing mode.
    }
}

interface State {
    void handle();
}

class EditingState implements State {
    @Override
    public void handle() {
        System.out.println("Document is in editing mode.");
    }
}

class ReadOnlyState implements State {
    @Override
    public void handle() {
        System.out.println("Document is in read-only mode.");
    }
}

class DocumentContext {
    private State currentState;

    public DocumentContext() {
        currentState = new ReadOnlyState(); // default state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void applyState() {
        currentState.handle();
    }
}

/*
Intent:
To allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

Context: The class that maintains an instance of a State subclass that defines the current state.
State (interface): An interface that defines the method(s) that all concrete states must implement.
ConcreteState: Classes that implement the State interface. Each class defines behavior for a specific state of the context.

When to Use the State Pattern :
When an object’s behavior depends on its state and it must change its behavior at runtime depending on that state.
When operations have large conditional statements that depend on the object’s state.

Benefits:
Avoids monolithic if/else or switch statements.
Makes state transitions explicit.
Improves code organization by putting state-specific behaviors into separate classes.

*/