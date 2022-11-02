package plants;

public class Flower extends Plant {

    public Flower(PlantSize plantSize, String name, boolean isBlooming) {
        super(plantSize, name);
        this.isBlooming = isBlooming;
    }

    private boolean isBlooming;

    public boolean isBlooming() {
        return isBlooming;
    }

    public void bloom() {
        this.isBlooming = true;
    }

    public void wither() {
        this.isBlooming = false;
    }

    @Override
    public String toString() {
        return String.format("Flower{isBlooming=%s}", isBlooming);
    }
}
