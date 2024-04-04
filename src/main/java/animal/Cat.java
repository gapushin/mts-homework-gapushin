package animal;

public class Cat extends Pet {
    public Cat(String breed, String name, String character, Double cost) {
        super(breed, name, character, cost);
    }

    @Override
    public void makePetSound() {
        System.out.println("Я киска, мяу");
    }
}
