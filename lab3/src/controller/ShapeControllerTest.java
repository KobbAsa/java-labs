package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;

public class ShapeControllerTest {
    private Shape[] shapes;
    private ShapeController controller;

    @BeforeEach
    public void setUp() {
        shapes = new Shape[]{
                new Rectangle("Red", 3, 4),   // 12
                new Circle("Blue", 5),        // ~78.54
                new Triangle("Green", 3, 6),  // 9
                new Rectangle("Blue", 5, 6),   // 30
                new Triangle("Red", 6, 9)  // 27

        };
        controller = new ShapeController(shapes);
    }

    @Test
    public void testCalculateTotalArea() {
        double totalArea = controller.calculateTotalArea();
        assertEquals(156.54, totalArea, 0.01);
    }

    @Test
    public void testCalculateTotalAreaByType() {
        double rectangleArea = controller.calculateTotalAreaByType(Rectangle.class);
        assertEquals(42.0, rectangleArea, 0.01);

        double circleArea = controller.calculateTotalAreaByType(Circle.class);
        assertEquals(78.54, circleArea, 0.01);

        double triangleArea = controller.calculateTotalAreaByType(Triangle.class);
        assertEquals(36, triangleArea, 0.01);
    }

    @Test
    public void testSortByArea() {
        controller.sortByArea();
        assertTrue(shapes[0].calcArea() <= shapes[1].calcArea());
        assertTrue(shapes[1].calcArea() <= shapes[2].calcArea());
        assertTrue(shapes[2].calcArea() <= shapes[3].calcArea());
        assertTrue(shapes[3].calcArea() <= shapes[4].calcArea());
    }

    @Test
    public void testSortByColor() {
        controller.sortByColor();
        assertEquals("Blue", shapes[0].getShapeColor());
        assertEquals("Blue", shapes[1].getShapeColor());
        assertEquals("Green", shapes[2].getShapeColor());
        assertEquals("Red", shapes[3].getShapeColor());
        assertEquals("Red", shapes[4].getShapeColor());
    }
}
