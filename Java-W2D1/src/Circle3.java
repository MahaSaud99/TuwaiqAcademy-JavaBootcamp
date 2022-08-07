public class Circle3 extends Shape {
    private double radius= 1.0;

    public Circle3(){
    }

    public Circle3(double radius) {
        this.radius = radius;
    }

    public Circle3(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea(){
        return Math.PI*getRadius()*getRadius();
    }

    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}

