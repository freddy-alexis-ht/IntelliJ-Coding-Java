package builder;

public class Cat {

    private String name;
    private String sound;

    public Cat(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public static CatBuilder builder() {
        return new CatBuilder();
    }

    public static class CatBuilder {
        private String name;
        private String sound;

        public CatBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CatBuilder setSound(String sound) {
            this.sound = sound;
            return this;
        }

        public Cat build() {
            return new Cat(name, sound);
        }
    }
}


