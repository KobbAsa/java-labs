import controller.ShapeController;
import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;
import view.ShapeView;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        Random random = new Random();

        // Random shapes creation
        for (int i = 0; i < shapes.length; i++) {
            int randomShape = random.nextInt(3);
            switch (randomShape) {
                case 0:
                    shapes[i] = new Rectangle("Red", random.nextDouble() * 10, random.nextDouble() * 10);
                    break;
                case 1:
                    shapes[i] = new Triangle("Blue", random.nextDouble() * 10, random.nextDouble() * 10);
                    break;
                case 2:
                    shapes[i] = new Circle("Green", random.nextDouble() * 10);
                    break;
            }
        }

        ShapeController controller = new ShapeController(shapes);
        ShapeView view = new ShapeView();

        view.showMessage("Displaying shapes:");
        controller.displayShapes();

        view.showMessage("\nTotal area of all shapes: " + controller.calculateTotalArea());

        view.showMessage("\nTotal area of all rectangles: " + controller.calculateTotalAreaByType(Rectangle.class));
        view.showMessage("Total area of all circles: " + controller.calculateTotalAreaByType(Circle.class));
        view.showMessage("Total area of all triangles: " + controller.calculateTotalAreaByType(Triangle.class));

        view.showMessage("\nSorting by area:");
        controller.sortByArea();
        controller.displayShapes();

        view.showMessage("\nSorting by color:");
        controller.sortByColor();
        controller.displayShapes();
    }
}
