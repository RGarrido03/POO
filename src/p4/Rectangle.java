package p4;

public class Rectangle {
    private double length;
    private double height;

    public Rectangle(double length, double height) {
        this.setLength(length);
        this.setHeight(height);
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
        return "Rectangle { length: " + length + ", height: " + height + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        Rectangle compRectangle = (Rectangle) o;

        if (compRectangle.length == this.length && compRectangle.height == this.height) {
            return true;
        } else {
            return false;
        }
    }
}
