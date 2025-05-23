package neeraj.design.structural;

import java.util.Objects;

public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");

        // Image not yet loaded
        System.out.println("First time calling display:");
        image1.display();  // Loads and displays

        System.out.println("\nSecond time calling display:");
        image1.display();  // Uses cached real image
    }
}

interface Image {
    void display();
}


class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // Simulate expensive operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy initialization
        }
        realImage.display();
    }
}

/*
Use Case:
Suppose you have an application that shows images, but downloading and displaying large images is resource-intensive.
 You can use a proxy to delay the actual download until the image is really needed (e.g., when it's being viewed).

✅ Components
Subject interface: Image
Real subject: RealImage (downloads and displays the image)
Proxy: ProxyImage (loads the real image only when needed)

✅ Benefits of Proxy in This Case:
Lazy Loading: Delays resource-heavy operations until necessary.
Performance: Prevents unnecessary object creation.
Encapsulation: Hides the heavy initialization logic from the client.

Let me know if you'd like to extend this with:
Logging proxy (for analytics),
Access control proxy (e.g., image downloads for premium users),
Caching proxy (avoid re-downloading from network).

 */

