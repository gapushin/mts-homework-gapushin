package animal;

public class Dog extends Pet {
    public Dog(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public void makePetSound() {
        System.out.println("Я собачка, тяф-тяф");
        super.makePetSound();
    }
}
