package animal;

public class Pet extends AbstractAnimal {
    public Pet(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }

    @Override
    public void printAnimalData () {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: "+ this.getName() + " Цена: " + this.getCost()+ " А еще я домашний <3");
    }

    public void makePetSound () {
        System.out.println("Я сладенький питомец");
    }
}
