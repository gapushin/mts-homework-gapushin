package animal;

import animal.ranomizer.Randomizer;

import java.util.*;

public interface AnimalService {
        default Map<String, List<Animal>> createAnimals() {
        int count = 0;
        Map<String, List<Animal>> animalsMap = new HashMap<>();

        while (count < 10) {
            Animal animal = createRandomAnimal();

            animalsMap.computeIfAbsent(animal.getClassName(), item -> new ArrayList<>()).add(animal);
            count++;
        }

        return  animalsMap;
    }

    default Animal createRandomAnimal() {
        Randomizer randomizer = new Randomizer();
        int randomValue = new Random().nextInt(4);

        switch (randomValue) {
            case 0:
                return new Cat(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
            case 1:
                return new Dog(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
            case 2:
                return new Wolf(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
            default:
                return new Shark(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());
        }
    }
}
