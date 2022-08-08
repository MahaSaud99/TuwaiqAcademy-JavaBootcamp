public class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(int x, int y){

        int subtractrResX=x-this.x;
        int subtractResY=y-this.y;

        int squareX=subtractrResX*subtractrResX;
        int squareY=subtractResY*subtractResY;

        int sum=squareX+squareY;

        return Math.sqrt(sum);
    }

    public double distance(MyPoint another){
        return distance(another.getX(),another.getY());
    }

    public double distance(){
        return distance(0,0);
    }
}
