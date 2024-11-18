package controller;

import model.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeController {
    private Shape[] shapes;

    public ShapeController(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void displayShapes() {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public double calculateTotalArea() {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calcArea();
        }
        return total;
    }

    public double calculateTotalAreaByType(Class<?> shapeClass) {
        double total = 0;
        for (Shape shape : shapes) {
            if (shape.getClass() == shapeClass) {
                total += shape.calcArea();
            }
        }
        return total;
    }

    public void sortByArea(){
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortByColor(){
        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));
    }
}