package p4;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle { radius: " + radius + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        Circle compCircle = (Circle) o;

        if (compCircle.radius == this.radius) {
            return true;
        } else {
            return false;
        }
    }
}
