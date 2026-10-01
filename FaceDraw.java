import java.util.ArrayList;

public class FaceDraw {

    public static void main(String[] args) {

        ArrayList<Face> FaceList = new ArrayList<Face>();

        FaceList.add(new Face());
        FaceList.add(new Face(120, 120));
        FaceList.add(new Face(150, 150, 200, 100, false));

        System.out.println("Faces in FaceList:");

        for (Face face : FaceList) {
            System.out.println(face);
        }
    }
}