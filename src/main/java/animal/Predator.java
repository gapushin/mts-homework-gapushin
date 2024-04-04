package animal;

public class Predator extends AbstractAnimal {
    public Predator(String breed, String name, String character, Double cost) {
        super(breed, name, character, cost);
    }
    
    @Override
    public void printAnimalData () {
        System.out.println("Порода: " + getBreed() + " Характер: " + getCharacter() + " Имя: "+ getName() + " Цена: " + getCost()+ " Я злой и опасный!");
    }

    public void makeRoar () {
        System.out.println("Гррр, я злобный хищник");
    }
}
