package dk.sdu.mmmi.cbse.asteroidsystem;
/**
 *
 * @author Phillip O
 */
public enum AsteroidType {
    LARGE("LARGE"),
    MEDIUM("MEDIUM"),
    SMALL("SMALL");

    private final String size;

    AsteroidType(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}