package animal;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String breed, String name, String character, Double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    @Override
    public void makePetSound() {
        System.out.println("Я киска, мяу");
    }
}
