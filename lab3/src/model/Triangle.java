package model;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return (base * height) / 2;
    }

    @Override
    public void draw(){
        System.out.println("Drawing triangle");
    }

    @Override
    public String toString() {
     return "Triangle with color: " + shapeColor + " and area: " + calcArea();
    }
}