public class Face {

    private int width;
    private int height;
    private int x;
    private int y;
    private boolean smiling;

    
    public Face() {
        width = 100;
        height = 100;
        x = 0;
        y = 0;
        smiling = true;
    }

  
    public Face(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
        smiling = true;
    }

   
    public Face(int width, int height, int x, int y, boolean smiling) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.smiling = smiling;
    }


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

    public boolean getSmiling() {
        return smiling;
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

    public void setSmiling(boolean smiling) {
        this.smiling = smiling;
    }

    // toString method
    public String toString() {
        return "Width: " + width +
               ", Height: " + height +
               ", X: " + x +
               ", Y: " + y +
               ", Smiling: " + smiling;
    }
}