package plants;

import java.util.Objects;

public class PlantSize {

    private final SizeUnit unit;
    private double height;
    private double diameter;

    public PlantSize(double height, double diameter, SizeUnit unit) {
        if (height < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        if (diameter < 0) {
            throw new IllegalArgumentException("diameter must be >= 0");
        }
        this.height = height;
        this.diameter = diameter;
        this.unit = Objects.requireNonNull(unit);
    }

    void increaseDiameter(double increaseBy) {
        if (increaseBy <= 0) {
            throw new IllegalArgumentException("must be a positive number");
        }
        this.diameter += increaseBy;
    }

    void increaseHeight(double increaseBy) {
        if (increaseBy <= 0) {
            throw new IllegalArgumentException("must be a positive number");
        }
        this.height += increaseBy;
    }

    public double getHeight() {
        return height;
    }

    public double getDiameter() {
        return diameter;
    }

    public SizeUnit getUnit() {
        return unit;
    }
}
