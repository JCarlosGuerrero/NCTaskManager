package mx.edu.j2se.Guerrero.evaluation;

public class Circle {

    private double radius;

    public Circle() {
        this.radius = 1;
    }
    public Circle(double radius) throws IllegalArgumentException {
        if(radius < 0) {
            throw new IllegalArgumentException("Radius  cannot be negative");
        }
        this.radius = radius;
    }

    public void setRadius(int radius) {
        if(radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    public double getRadius() {return radius;}

    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }
}
