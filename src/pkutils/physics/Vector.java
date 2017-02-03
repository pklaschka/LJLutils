package pkutils.physics;

import com.sun.javafx.geom.Vec3d;

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

    public double dot(Vector secondVector) {
        return this.x * secondVector.x + this.y * secondVector.y + this.z * secondVector.z;
    }

    public Vector cross(Vector secondVector) {
        x = this.y * secondVector.z - this.z * secondVector.y;
        y = this.z * secondVector.x - this.x * secondVector.z;
        z = this.x * secondVector.y - this.y * secondVector.x;
        return new Vector(x, y, z);
    }

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

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}