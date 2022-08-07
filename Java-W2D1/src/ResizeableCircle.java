public class ResizeableCircle extends Circle implements Resizeable {
    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public String toString() {
        return "ResizeableCircle{}";
    }

    @Override
    public void resize(int percent) {
        super.setRadius(super.getRadius()*percent/100.0);
    }
}
