package animal;

public class Wolf extends Predator {
    public Wolf (String breed, String name, String character, Double cost) {
        super(breed, name, character, cost);
    }

    @Override
    public void makeRoar () {
        System.out.println("Я волк - я вою на луну: ауууууууу");
    }
}
