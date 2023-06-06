package ss6_inheritance.exercise.point_2D_and_point_3D_class;

public class Point3D extends Point2D {
    private float z = 0.0f;

    Point3D() {
    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] array = new float[]{super.getX(), super.getY(), this.z};
        return array;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.setZ(z);
    }

    @Override
    public String toString() {
        return "(" + super.getX() + ", " + super.getY() + ", " + this.z + ")";
    }
}
