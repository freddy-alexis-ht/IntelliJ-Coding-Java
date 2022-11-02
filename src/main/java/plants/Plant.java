package plants;

public abstract class Plant implements Growable {

    private final PlantSize plantSize;
    private final String name;

    public Plant(PlantSize plantSize, String name) {
        this.plantSize = plantSize;
        this.name = name;
    }

    @Override
    public PlantSize growHeight(double distance) {
        this.plantSize.increaseHeight(distance);
        return this.plantSize;
    }

    @Override
    public PlantSize growDiameter(double distance) {
        this.plantSize.increaseDiameter(distance);
        return this.plantSize;
    }

    public PlantSize getPlantSize() {
        return plantSize;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }
}
