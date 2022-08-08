public class Point2D{
    private float x=0.0f;
    private float y=0.0f;



    public Point2D(float x, float y) {
        setX(x);
        setY(y);
    }

    public Point2D() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        float arr[]={this.x,this.y};
        return arr;
    }

    public void setXY(float x, float y){
       setX(x);
       setY(y);
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
