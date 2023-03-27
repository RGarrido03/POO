package p7;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        this.setRadius(radius);
        this.setColor(color);
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
        return "Circle { radius: " + radius + ", color: " + this.getColor() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else {
            Circle compCircle = (Circle) o;
            return compCircle.getRadius() == this.radius && compCircle.getColor().equals(this.getColor());
        }
    }
}
