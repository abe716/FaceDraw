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
    public Face(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
        mouth = 1;
    }

    // Third constructor
    public Face(int width, int height, int x, int y, int mouth) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.mouth = mouth;
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
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    
    public String toString() {
        return "Width: " + width +
               ", Height: " + height +
               ", X: " + x +
               ", Y: " + y +
               ", Mouth: " + mouth;
    }
}