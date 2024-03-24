package animal;

public class Cat extends Pet {
    public Cat(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public void makePetSound() {
        System.out.println("Я киска, мяу");
    }
}
