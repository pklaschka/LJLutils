package ljlutils.physics;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector() {
        x = y = z = 0;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    //region Static math
    public static Vector getMultipliedVector(Vector vector, double factor) {
        vector = (Vector) vector.clone();
        vector.multiply(factor);
        return vector;
    }

    public static Vector getMultipliedVector(Vector vector, Vector factor) {
        vector = (Vector) vector.clone();
        vector.multiply(factor);
        return vector;
    }

    public static Vector getAddedVector(Vector vector, Vector secondVector) {
        vector = (Vector) vector.clone();
        vector.add(secondVector);
        return vector;
    }

    public static Vector getSubtractedVector(Vector vector, Vector secondVector) {
        vector = (Vector) vector.clone();
        vector.subtract(secondVector);
        return vector;
    }

    public static Vector getCrossProductVector(Vector vector, Vector secondVector) {
        vector = (Vector) vector.clone();
        vector.cross(secondVector);
        return vector;
    }

    public static double getDotProduct(Vector vector, Vector secondVector) {
        vector = (Vector) vector.clone();
        return vector.dot(secondVector);
    }

    public static Vector getDividedVector(Vector vector, double factor) {
        vector = (Vector) vector.clone();
        vector.divide(factor);
        return vector;
    }

    public static Vector getDividedVector(Vector vector, Vector divider) {
        vector = (Vector) vector.clone();
        vector.divide(divider);
        return vector;
    }
    //endregion

    //region Concrete math
    public double getMagnitude() {
        double xyComponent = Math.sqrt(x * x + y * y);
        return Math.sqrt(xyComponent * xyComponent + z * z);
    }

    public void setMagnitude(double magnitude) {
        double factor = magnitude / getMagnitude();
        this.multiply(factor);
    }

    public void multiply(double factor) {
        this.multiply(new Vector(factor, factor, factor));
    }

    public void multiply(Vector factor) {
        this.x *= factor.x;
        this.y *= factor.y;
        this.z *= factor.z;
    }

    public void add(Vector factor) {
        this.x += factor.x;
        this.y += factor.y;
        this.z += factor.z;
    }

    public void subtract(Vector factor) {
        this.x -= factor.x;
        this.y -= factor.y;
        this.z -= factor.z;
    }

    public void divide(Vector divider) {
        this.x /= divider.x;
        this.y /= divider.y;
        this.z /= divider.z;
    }

    public void divide(double divider) {
        this.divide(new Vector(divider, divider, divider));
    }

    public double dot(Vector secondVector) {
        return this.x * secondVector.x + this.y * secondVector.y + this.z * secondVector.z;
    }

    public Vector cross(Vector secondVector) {
        x = this.y * secondVector.z - this.z * secondVector.y;
        y = this.z * secondVector.x - this.x * secondVector.z;
        z = this.x * secondVector.y - this.y * secondVector.x;
        return new Vector(x, y, z);
    }
    //endregion


    //region Getters and setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    //endregion

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    protected Object clone() {
        return new Vector(x, y, z);
    }
}