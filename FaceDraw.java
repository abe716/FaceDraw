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

        // Randomly choose between 3 and 10 faces
        int numberOfFaces = random.nextInt(8) + 3;

        // Create the faces
        for (int i = 0; i < numberOfFaces; i++) {

            // Random size between 70 and 130
            int size = random.nextInt(61) + 70;

            // Random location
            int x = random.nextInt(650);
            int y = random.nextInt(350);

            // Random mouth
            int mouth = random.nextInt(3);

            Face face = new Face(size, size, x, y, mouth);

            FaceList.add(face);
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // White background
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

        // Draw face
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);

        // Draw eyes
        g.setColor(Color.BLACK);

        g.fillOval(x + width / 4, y + height / 3, 15, 20);
        g.fillOval(x + 3 * width / 4 - 15, y + height / 3, 15, 20);

        // Draw mouth
        if (face.getMouth() == 2) {

            // Smile
            g.drawArc(
                x + width / 4,
                y + height / 2,
                width / 2,
                height / 4,
                200,
                140
            );

        } else if (face.getMouth() == 0) {

            // Frown
            g.drawArc(
                x + width / 4,
                y + height / 2,
                width / 2,
                height / 4,
                20,
                140
            );

        } else {

            // Neutral
            g.drawLine(
                x + width / 3,
                y + height / 2 + 20,
                x + 2 * width / 3,
                y + height / 2 + 20
            );
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