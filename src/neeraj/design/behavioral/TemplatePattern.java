package neeraj.design.behavioral;

public class TemplatePattern {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();

        System.out.println();
        game = new Chess();
        game.play();
    }
}

abstract class Game {
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

}

class Football extends Game {
    @Override
    protected void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    protected void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    protected void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

class Chess extends Game {
    @Override
    protected void initialize() {
        System.out.println("Chess Game Initialized! Start playing.");
    }

    @Override
    protected void startPlay() {
        System.out.println("Chess Game Started. Enjoy the game!");
    }

    @Override
    protected void endPlay() {
        System.out.println("Chess Game Finished!");
    }
}

/*

The Template Method Design Pattern is a behavioral pattern that defines the skeleton of an algorithm in a method,
deferring some steps to subclasses. It lets subclasses redefine certain steps without
changing the overall structure of the algorithm.

Intent:
Define the program skeleton of an algorithm in an operation, deferring some steps to subclasses.

When to Use:
When multiple classes share a common algorithm structure but differ in specific steps.
When you want to control the sequence of steps in an algorithm.

Benefits:
Encourages code reuse.
Easy to maintain and extend.
Follows the Hollywood Principle: “Don't call us, we’ll call you.
* */