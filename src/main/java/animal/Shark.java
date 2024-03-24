package animal;

public class Shark extends Predator {
    public Shark(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public void makeRoar () {
        System.out.println("Клац, клац! Я Акулка!");
    }
}
