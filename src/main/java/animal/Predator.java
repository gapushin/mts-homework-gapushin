package animal;

public class Predator extends AbstractAnimal {
    public Predator(String _breed, String _name, String _character, Double _cost) {
        super(_breed, _name, _character, _cost);
    }
    
    @Override
    public void printAnimalData () {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: "+ this.getName() + " Цена: " + this.getCost()+ " Я злой и опасный!");
    }

    public void makeRoar () {
        System.out.println("Гррр, я злобный хищник");
    }
}
