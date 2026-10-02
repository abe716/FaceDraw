import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FaceDraw extends JPanel {

    private ArrayList<Face> FaceList;
    private Random random;

    // Constructor
    public FaceDraw() {

        FaceList = new ArrayList<Face>();
        random = new Random();

        // Random number of faces from 3 to 10
        int numberOfFaces = random.nextInt(8) + 3;

        // Create the faces
        for (int i = 0; i < numberOfFaces; i++) {

            // Random size from 70 to 120
            int size = random.nextInt(51) + 70;

            // Starting values for the location
            int x = 0;
            int y = 0;

            boolean goodPosition = false;

            // Keep looking for a position that does not overlap
            while (!goodPosition) {

                // Random location
                x = random.nextInt(680);
                y = random.nextInt(350);

                goodPosition = true;

                // Check the new face against faces already created
                for (Face oldFace : FaceList) {

                    int oldX = oldFace.getX();
                    int oldY = oldFace.getY();
                    int oldSize = oldFace.getWidth();

                    // Check if the faces overlap
                    if (x < oldX + oldSize + 10 &&
                        x + size + 10 > oldX &&
                        y < oldY + oldSize + 10 &&
                        y + size + 10 > oldY) {

                        goodPosition = false;
                    }
                }
            }

            // Random mouth
            // 0 = frown
            // 1 = straight/neutral
            // 2 = smile
            int mouth = random.nextInt(3);

            // Create the Face
            Face face = new Face(size, size, x, y, mouth);

            // Add the Face to FaceList
            FaceList.add(face);

            // Print Face information in the terminal
            System.out.println(face);
        }
    }

    // Draw everything
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

    // Draw one face
    public void drawFace(Graphics g, Face face) {

        int x = face.getX();
        int y = face.getY();
        int width = face.getWidth();
        int height = face.getHeight();

        // Draw the yellow face
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);

        // Choose eye color
        Color eyeColor;

        // Smiling face
        if (face.getMouth() == 2) {

            // 50% green and 50% blue
            if (random.nextBoolean()) {
                eyeColor = Color.GREEN;
            } else {
                eyeColor = Color.BLUE;
            }

        // Straight/neutral face
        } else if (face.getMouth() == 1) {

            eyeColor = Color.YELLOW;

        // Frowning face
        } else {

            eyeColor = Color.RED;
        }

        // Black outline for left eye
        g.setColor(Color.BLACK);
        g.fillOval(
            x + width / 4,
            y + height / 3,
            20,
            25
        );

        // Black outline for right eye
        g.fillOval(
            x + 3 * width / 4 - 20,
            y + height / 3,
            20,
            25
        );

        // Colored part of left eye
        g.setColor(eyeColor);
        g.fillOval(
            x + width / 4 + 3,
            y + height / 3 + 3,
            14,
            19
        );

        // Colored part of right eye
        g.fillOval(
            x + 3 * width / 4 - 17,
            y + height / 3 + 3,
            14,
            19
        );

        // Draw the mouth
        g.setColor(Color.BLACK);

        // Smile
        if (face.getMouth() == 2) {

            g.drawArc(
                x + width / 4,
                y + height / 2,
                width / 2,
                height / 4,
                200,
                140
            );

        // Frown
        } else if (face.getMouth() == 0) {

            g.drawArc(
                x + width / 4,
                y + height / 2 + 10,
                width / 2,
                height / 4,
                20,
                140
            );

        // Straight/neutral
        } else {

            g.drawLine(
                x + width / 3,
                y + height / 2 + 20,
                x + 2 * width / 3,
                y + height / 2 + 20
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        JFrame frame = new JFrame("Face Draw");

        FaceDraw panel = new FaceDraw();

        frame.add(panel);

        frame.setSize(800, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}