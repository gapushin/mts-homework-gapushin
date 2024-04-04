package animal;

public class Shark extends Predator {
    public Shark(String breed, String name, String character, Double cost) {
        super(breed, name, character, cost);
    }

    @Override
    public void makeRoar () {
        System.out.println("Клац, клац! Я Акулка!");
    }
}
