package p7;

public class Rectangle extends Shape {
    private double length;
    private double height;

    public Rectangle(double length, double height, String color) {
        this.setLength(length);
        this.setHeight(height);
        this.setColor(color);
    }

    public void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be positive");
        this.length = length;
    }

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be positive");
        this.height = height;
    }

    public double getLength() { return length; }
    public double getHeight() { return height; }

    public double perimeter() {
        return 2 * length + 2 * height;
    }

    public double area() {
        return length * height;
    }

    @Override
    public String toString() {
        return "Rectangle { length: " + length + ", height: " + height + ", color: " + this.getColor() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else {
            Rectangle compRectangle = (Rectangle) o;
            return compRectangle.length == this.length && compRectangle.height == this.height && compRectangle.getColor().equals(this.getColor());
        }
    }
}
