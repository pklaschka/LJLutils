package llutils.physics;

import java.util.ArrayList;

public class PhysicalObject {
    //<editor-fold desc="Logik-Aufbau">
    private static ArrayList<PhysicalObject> objects;
    private static double timeSteps;

    static {
        objects = new ArrayList<PhysicalObject>();
        timeSteps = 1;
    }

    {
        addObject(this);
    }

    protected static void addObject(PhysicalObject physicalObject) {
        objects.add(physicalObject);
    }

    public static void stepAllForward() {
        for (PhysicalObject physicalObject : objects) {
            physicalObject.stepForward(timeSteps);
        }
    }

    public static double getTimeSteps() {
        return timeSteps;
    }

    public static void setTimeSteps(double timeSteps) {
        PhysicalObject.timeSteps = timeSteps;
    }

    //</editor-fold>

    protected double mass;

    /**
     * Position in meters
     */
    protected Vector position;
    /**
     * Velocity in m/s
     */
    protected Vector velocity;
    /**
     * Acceleration in m/s^2
     */
    protected Vector acceleration;
    /**
     * Force in Newton
     */
    protected Vector force;

    public PhysicalObject(double mass, Vector position, Vector velocity, Vector acceleration, Vector force) {
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.force = force;
    }

    public PhysicalObject(double mass, Vector position) {
        this(mass, position, new Vector(), new Vector(), new Vector());
    }

    public PhysicalObject(double mass) {
        this(mass, new Vector());
    }

    public void addForce(Vector force) {
        this.force.add(force);
    }

    /**
     * @param t The forwarded time in seconds
     */
    protected void stepForward(double t) {
        // Calculate physics here.

        // a = F * t / m
        acceleration.add(Vector.getMultipliedVector(Vector.getDividedVector(force, mass), t));

        // v = a * t
        velocity.add(Vector.getMultipliedVector(acceleration, t));

        // pos = v * t
        position.add(Vector.getMultipliedVector(velocity, t));

        // Reset force and acceleration
        this.force = new Vector();
        this.acceleration = new Vector();
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    public Vector getForce() {
        return force;
    }

    public void setForce(Vector force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return "PhysicalObject{" +
                "mass=" + mass +
                ", position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                ", force=" + force +
                '}';
    }
}
