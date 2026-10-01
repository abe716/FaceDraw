import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FaceDraw extends JPanel {

    private ArrayList<Face> FaceList;
    private Random random;

    public FaceDraw() {

        FaceList = new ArrayList<Face>();
        random = new Random();

        // Create 5 faces
        for (int i = 0; i < 5; i++) {

            int width = 100;
            int height = 100;

            int x = random.nextInt(600);
            int y = random.nextInt(350);

            int mouth = random.nextInt(3);

            Face face = new Face(width, height, x, y, mouth);

            FaceList.add(face);
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw every face
        for (Face face : FaceList) {
            drawFace(g, face);
        }
    }

    public void drawFace(Graphics g, Face face) {

        int x = face.getX();
        int y = face.getY();
        int width = face.getWidth();
        int height = face.getHeight();

        // Face
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);

        // Eyes
        g.setColor(Color.BLACK);

        g.fillOval(x + 25, y + 30, 15, 20);
        g.fillOval(x + 60, y + 30, 15, 20);

        // Mouth
        if (face.getMouth() == 2) {

            // Smile
            g.drawArc(x + 25, y + 45, 50, 30, 200, 140);

        } else if (face.getMouth() == 0) {

            // Frown
            g.drawArc(x + 25, y + 60, 50, 30, 20, 140);

        } else {

            // Neutral
            g.drawLine(x + 30, y + 65, x + 70, y + 65);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Face Draw");

        FaceDraw panel = new FaceDraw();

        frame.add(panel);

        frame.setSize(800, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}