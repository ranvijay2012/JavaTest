package neeraj.design.structural;

public class FacadePattern {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights);

        homeTheater.watchMovie("The Matrix");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier ON");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector ON");
    }

    public void wideScreenMode() {
        System.out.println("Setting projector to widescreen mode");
    }
}

class Lights {
    public void dim(int level) {
        System.out.println("Dimming lights to " + level + "%");
    }
}

class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Lights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }
}

/*
The Facade Design Pattern is a structural design pattern that provides a simplified, unified interface to a set
of interfaces in a subsystem. It helps hide the complexities of the system and provides a cleaner, higher-level API.

🧠 Key Concepts
The Facade acts as a wrapper that delegates requests to the appropriate objects in the subsystem.
Helps decouple a client from a complex subsystem.
Makes the system easier to use for clients.

✅ When to Use
When you want to provide a simple interface to a complex system.
To reduce coupling between subsystems and their clients.
To layer your application architecture (e.g., separating UI from business logic).

🧩 Benefits
Simplifies usage for clients.
Decouples code from complex subsystem logic.
Promotes separation of concerns.

⚠️ Drawbacks
May become a "god object" if not carefully designed.
Overusing facades can hide important system functionality from users.

 */
