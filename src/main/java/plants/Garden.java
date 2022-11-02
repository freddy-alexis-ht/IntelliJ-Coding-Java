package plants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public class Garden {

    private final Collection<Planting> plantings = new ArrayList<>();

    public void plant(Plant plant) {
        this.plantings.add(new Planting(plant));
    }

    public int countPlants() {
        return plantings.size();
    }

    public Collection<Planting> getPlantings() {
        return plantings;
    }

    public Stream<Flower> findFlowers() {
        return this.plantings.stream()
                .filter(planting -> planting.getPlant() instanceof Flower)
                .map(planting -> (Flower) planting.getPlant());
    }

    public static class Planting {
        private final UUID uuid;
        private final LocalDate plantedOn;
        private final Plant plant;

        public Planting(Plant plant) {
            this.uuid = UUID.randomUUID();
            this.plantedOn = LocalDate.now();
            this.plant = plant;
        }

        public UUID getUuid() {
            return uuid;
        }

        public LocalDate getPlantedOn() {
            return plantedOn;
        }

        public Plant getPlant() {
            return plant;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Planting planting = (Planting) o;
            return uuid.equals(planting.uuid);
        }

        @Override
        public int hashCode() {
            return Objects.hash(uuid);
        }

        @Override
        public String toString() {
            return "Planting{" +
                    "uuid=" + uuid +
                    ", plantedOn=" + plantedOn +
                    ", plant=" + plant +
                    '}';
        }
    }

}
