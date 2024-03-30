package animal;

public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, String character, Double cost) {
        super(breed, name, character, cost);
    }

    @Override
    public void printAnimalData () {
        System.out.println("Порода: " + getBreed() + " Характер: " + getCharacter() + " Имя: "+ getName() + " Цена: " + getCost()+ " А еще я домашний <3");
    }

    public void makePetSound () {
        System.out.println("Я сладенький питомец");
    }
}
