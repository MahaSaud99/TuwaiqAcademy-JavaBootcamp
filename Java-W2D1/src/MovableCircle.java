public class MovableCircle implements Movable {
    private int redius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed , int ySpeed , int redius) {
        this.center = new MovablePoint(x,y,xSpeed,ySpeed);
        this.redius=redius;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "redius=" + redius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}
