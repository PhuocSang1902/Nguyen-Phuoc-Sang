package ss6_inheritance.exercise.point_and_moveable_point_class;

public class MovablePoint extends Point {
    private float xSpeech = 0.0f;
    private float ySpeech = 0.0f;

    MovablePoint() {
    }

    MovablePoint(float xSpeech, float ySpeech) {
        this.xSpeech = xSpeech;
        this.ySpeech = ySpeech;
    }

    MovablePoint(float x, float y, float xSpeech, float ySpeech) {
        super(x, y);
        this.xSpeech = xSpeech;
        this.ySpeech = ySpeech;
    }

    public float getXSpeech() {
        return xSpeech;
    }

    public void setXSpeech(float xSpeech) {
        this.xSpeech = xSpeech;
    }

    public float getYSpeech() {
        return ySpeech;
    }

    public void setYSpeech(float ySpeech) {
        this.ySpeech = ySpeech;
    }

    public void setSpeech(float xSpeech, float ySpeech) {
        setXSpeech(xSpeech);
        setYSpeech(ySpeech);
    }

    public float[] getSpeech() {
        float[] arr = new float[]{this.xSpeech, this.ySpeech};
        return arr;
    }

    public MovablePoint move() {
        super.setX(super.getX() + this.xSpeech);
        super.setY(super.getY() + this.ySpeech);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + ", speech = (" + this.xSpeech + ", " + this.ySpeech + ")";
    }
}
