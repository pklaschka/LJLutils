package pkutils.physics;

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
    }
}
