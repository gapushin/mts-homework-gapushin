package animal;

import java.time.LocalDate;

abstract class AbstractAnimal implements Animal {
    protected String breed;

    protected String className;
    protected String name;
    protected Double cost;
    protected String character;
    protected LocalDate birthDate;

    protected AbstractAnimal (String breed, String name, String character, Double cost, LocalDate birthDate) {
        this.className = "Animal";
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost;
        this.birthDate = birthDate;
    }

    @Override
    public String getClassName() {
        return className;
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

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate value) {
        birthDate = value;
    }

    public void printAnimalData () {
        System.out.println("Порода: " + getBreed() + " Характер: " + getCharacter() + " Имя: "+ getName() + " Цена: " + getCost() + " Дата рождения: " + getBirthDate());
    }
}
