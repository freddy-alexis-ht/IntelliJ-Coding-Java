package plants;

public class GardenApplication {

    public static void main(String[] args) {
        Garden myGarden = new Garden();
        Flower sunflower = new Flower(new PlantSize(10, 1, SizeUnit.CENTIMETERS), "Sunflower", false);
        Flower bluebell = new Flower(new PlantSize(5, 2, SizeUnit.CENTIMETERS), "Bluebell flower", true);
        Flower rose = new Flower(new PlantSize(30, 7, SizeUnit.CENTIMETERS), "Rose", true);

        myGarden.plant(sunflower);
        myGarden.plant(bluebell);
        myGarden.plant(rose);

        sunflower.growHeight(1);
        sunflower.bloom();

        bluebell.wither();
        rose.growDiameter(1);

        System.out.printf("There are %d plants in the garden%n", myGarden.countPlants());
        System.out.printf("%d flowers are blooming\n", myGarden.findFlowers().filter(Flower::isBlooming).count());
        myGarden.getPlantings().forEach(System.out::println);
    }
}
