package plants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GardenTest {

    private Garden garden;
    private Flower testFlower;

    @BeforeEach
    void setUp() {
        testFlower = new Flower(new PlantSize(10, 2, SizeUnit.CENTIMETERS), "Rose", false);
        garden = new Garden();
        garden.plant(testFlower);
    }

    @Test
    void countPlants() {
        assertThat(garden.countPlants()).isEqualTo(1);
    }

    @Test
    void testFindFlowers() {
        assertThat(garden.findFlowers()).containsExactly(testFlower);
    }
}
