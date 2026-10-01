public class Face {

    private int width;
    private int height;
    private int x;
    private int y;
    private int mouth;

    // Default constructor
    public Face() {
        width = 100;
        height = 100;
        x = 0;
        y = 0;
        mouth = 1;
    }

    // Second constructor
    public Face(int w, int h) {
        width = w;
        height = h;
        x = 0;
        y = 0;
        mouth = 1;
    }

    // Third constructor
    public Face(int w, int h, int xPosition, int yPosition, int mouthType) {
        width = w;
        height = h;
        x = xPosition;
        y = yPosition;
        mouth = mouthType;
    }

    // Getters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMouth() {
        return mouth;
    }

    // Setters
    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public void setX(int xPosition) {
        x = xPosition;
    }

    public void setY(int yPosition) {
        y = yPosition;
    }

    public void setMouth(int mouthType) {
        mouth = mouthType;
    }

    // toString method
    public String toString() {
        return "Width: " + width +
               ", Height: " + height +
               ", X: " + x +
               ", Y: " + y +
               ", Mouth: " + mouth;
    }
}