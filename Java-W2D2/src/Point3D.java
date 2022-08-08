public class Point3D extends Point2D{

    private float z=0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(){
        super();
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        float arr[]={super.getX(),super.getY(),getZ()};
        return arr;
    }

    public void setXYZ(float x, float y , float z){
        super.setX(x);
        super.setY(y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                '}';
    }
}
