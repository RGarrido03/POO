package p4;

public class Triangle {
    private double s1;
    private double s2;
    private double s3;

    public Triangle(double s1, double s2, double s3) {
        assert s1 < s2 + s3;
        this.setSides(s1, s2, s3);
    }

    public void setSides(double s1, double s2, double s3) {
        if (s1 <= 0 || s2 <= 0 || s3 <= 0) throw new IllegalArgumentException("Sides must be positive");
        if (s1 >= (s2 + s3)) throw new IllegalArgumentException("Triangle inequality is not verified");
        if (s2 >= (s1 + s3)) throw new IllegalArgumentException("Triangle inequality is not verified");
        if (s3 >= (s1 + s2)) throw new IllegalArgumentException("Triangle inequality is not verified");
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public double getS1() { return s1; }
    public double getS2() { return s2; }
    public double getS3() { return s3; }

    public double perimeter() {
        return s1 + s2 + s3;
    }

    public double area() {
        double s = (s1 + s2 + s3)/2;
        double area = s * (s-s1) * (s-s2) * (s-s3);
        return area;
    }

    @Override
    public String toString() {
        return "Triangle { side 1: " + s1 + ", side 2: " + s2 + ", side 3: " + s3 + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        Triangle compTriangle = (Triangle) o;

        if (compTriangle.s1 == this.s1 && compTriangle.s2 == this.s2 && compTriangle.s3 == this.s3) {
            return true;
        } else {
            return false;
        }
    }
}
