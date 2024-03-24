package animal;

abstract class AbstractAnimal implements IAnimal {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;

    protected AbstractAnimal (String _breed, String _name, String _character, Double _cost) {
        this.breed = _breed;
        this.name = _name;
        this.character = _character;
        this.cost = _cost;
    }

    @Override
    public Double getCost() {
        return this.cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    public void printAnimalData () {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: "+ this.getName() + " Цена: " + this.getCost());
    }
}
