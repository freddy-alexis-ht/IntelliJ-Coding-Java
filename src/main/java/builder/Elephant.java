package builder;

public class Elephant {

    private int weight;
    private int age;

    public Elephant(int weight, int age) {
        this.weight = weight;
        this.age = age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int weight;
        private int age;

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Elephant build() {
            return new Elephant(weight, age);
        }
    }
}
