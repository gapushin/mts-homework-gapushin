package animal;

import java.time.LocalDate;

public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, String character, Double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
        this.className = "Pet";
    }

    @Override
    public void printAnimalData () {
        System.out.println("Порода: " + getBreed() + " Характер: " + getCharacter() + " Имя: "+ getName() + " Цена: " + getCost() + " Дата рождения: " + getBirthDate() + " А еще я домашний <3");
    }

    public void makePetSound () {
        System.out.println("Я сладенький питомец");
    }
}
