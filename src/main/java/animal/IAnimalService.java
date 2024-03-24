package animal;

import java.util.Random;

public interface IAnimalService {
    default void createAnimals() {
        int count = 0;
        while (count < 10) {
            this.createRandomAnimal();
            count++;
        }
    }

    default void createRandomAnimal() {
        Randomizer randomizer = new Randomizer();
        int randomValue = new Random().nextInt(4);

        switch (randomValue) {
            case 0:
                Cat cat = new Cat(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast());
                cat.printAnimalData();
                cat.makePetSound();
                break;
            case 1:
                Dog dog = new Dog(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast());
                dog.printAnimalData();
                dog.makePetSound();
                break;
            case 2:
                Wolf wolf = new Wolf(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast());
                wolf.printAnimalData();
                wolf.makeRoar();
                break;
            default:
                Shark shark = new Shark(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast());
                shark.printAnimalData();
                shark.makeRoar();
                break;

        }
    }
}
