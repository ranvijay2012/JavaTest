package neeraj.design.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        ObserverContextImpl context = new ObserverContextImpl(150,2,15F);
        context.addObserver(new ScoreDetails());
        context.addObserver(new AverageScore());
        context.notifyObserver();

    }
}

interface Observer {
    void update(int runs, int wickets, float overs);
}

class ScoreDetails implements Observer {

    @Override
    public void update(int runs, int wickets, float overs) {
        System.out.println("Match details : Run(" + runs + "), wicket(" + wickets + ") and over(" + overs + ")");
    }
}

class AverageScore implements Observer {

    @Override
    public void update(int runs, int wickets, float overs) {
        float avg = runs / overs;
        System.out.println("Match score average is : " + avg + " after " + wickets + " lost");
    }
}

interface ObserverContext {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

class ObserverContextImpl implements ObserverContext {

    private int runs;
    private int wickets;
    private float overs;

    private List<Observer> observers;

    public ObserverContextImpl(int runs, int wickets, float overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(runs, wickets, overs));
    }
}


/*
Intent:
Establish a subscription mechanism to allow multiple objects (observers) to listen and react to events or changes in another object (subject).

Key Components:
Subject (Publisher): Maintains a list of observers and notifies them of any state changes.
Observer (Subscriber): Defines an updating interface for objects that should be notified of changes in the subject.
ConcreteSubject: A class that holds the actual state and sends notifications.
ConcreteObserver: A class that implements the Observer interface and updates its state based on Subject's updates.

✅ When to Use
When changes to one object require changes in others.
When you need a decoupled system between sender and receivers of data.

🔄 Benefits
Promotes loose coupling between the subject and observers.
Easy to add new observers without modifying the subject.
Improves scalability and reusability.

 */