package animal;

abstract class AbstractAnimal implements IAnimal {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;

    protected AbstractAnimal (String breed, String name, String character, Double cost) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    public void printAnimalData () {
        System.out.println("Порода: " + getBreed() + " Характер: " + getCharacter() + " Имя: "+ getName() + " Цена: " + getCost());
    }
}
