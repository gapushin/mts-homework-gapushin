package animal;

import animal.ranomizer.Randomizer;

import java.util.Random;

public interface IAnimalService {
    default void createAnimals() {
        int count = 0;
        while (count < 10) {
            createRandomAnimal();
            count++;
        }
    }

    default void createRandomAnimal() {
        Randomizer randomizer = new Randomizer();
        int randomValue = new Random().nextInt(4);

        switch (randomValue) {
            case 0:
                Cat cat = new Cat(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
                cat.printAnimalData();
                cat.makePetSound();
                break;
            case 1:
                Dog dog = new Dog(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
                dog.printAnimalData();
                dog.makePetSound();
                break;
            case 2:
                Wolf wolf = new Wolf(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
                wolf.printAnimalData();
                wolf.makeRoar();
                break;
            default:
                Shark shark = new Shark(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
                shark.printAnimalData();
                shark.makeRoar();
                break;

        }
    }
}
