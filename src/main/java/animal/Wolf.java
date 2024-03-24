package animal;

public class Wolf extends Predator {
    public Wolf (String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public void makeRoar () {
        System.out.println("Я волк - я вою на луну: ауууууууу");
    }
}
