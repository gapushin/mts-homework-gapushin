package animal;

public class Dog extends Pet {
    public Dog(String breed, String name, String character, Double cost) {
        super(breed, name, character, cost);
    }

    @Override
    public void makePetSound() {
        System.out.println("Я собачка, тяф-тяф");
        super.makePetSound();
    }
}
