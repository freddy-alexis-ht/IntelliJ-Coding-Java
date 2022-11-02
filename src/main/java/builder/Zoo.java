package builder;

public class Zoo {

    public static void main(String[] args) {
        Elephant elephant = new Elephant.Builder().setWeight(5000).build();
        Cat cat = Cat.builder().setName("Garphield").build();
    }
}
