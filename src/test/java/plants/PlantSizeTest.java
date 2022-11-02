package plants;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlantSizeTest {

    @Test
    void testGrowing() {
        PlantSize plantSize = new PlantSize(10.2, 3.1, SizeUnit.MILLIMETERS);
        plantSize.increaseDiameter(11.9);
        plantSize.increaseHeight(0.8);

        assertThat(plantSize.getDiameter()).isEqualTo(15.0);
        assertThat(plantSize.getHeight()).isEqualTo(11.0);
    }

    @Test
    void testShrinkingNotAllowed() {
        PlantSize plantSize = new PlantSize(10.2, 3.1, SizeUnit.MILLIMETERS);
        assertThatThrownBy(() -> plantSize.increaseHeight(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> plantSize.increaseDiameter(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
