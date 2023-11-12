package enums;

public enum Planet {

    EARTH(3.302e+23, 2.439e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double surfaceGravity() {
        return mass * surfaceGravity;
    }
}
