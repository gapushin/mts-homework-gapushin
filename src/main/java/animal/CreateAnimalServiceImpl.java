package animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements AnimalService {
    private void writeAnimalDataToFile(String filePath, Animal animal, int count) {
        Path path = Paths.get(filePath);
        String animalDataString = count + " " + animal.getBreed() + " " + animal.getName() + " " + animal.getCost() + " " + animal.getBirthDate() + "\n";

        try {
            Files.writeString(path, animalDataString, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeDelimiterToFile(String filePath) {
        Path path = Paths.get(filePath);

        try {
            Files.writeString(path, "— — — — — — — END — — — — — — — \n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, List<Animal>> createAnimals(int length) {
        Map<String, List<Animal>> animalsMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Animal animal = createRandomAnimal();
            animal.printAnimalData();
            writeAnimalDataToFile("resources/animals/logData.txt", animal, i + 1);

            animalsMap.computeIfAbsent(animal.getClassName(), item -> new ArrayList<>()).add(animal);
            i++;
        }
        writeDelimiterToFile("resources/animals/logData.txt");
        return animalsMap;
    }

    @Override
    public Map<String, List<Animal>> createAnimals() {
        int count = 0;
        Map<String, List<Animal>> animalsMap = new HashMap<>();

        do {
            Animal animal = createRandomAnimal();
            animal.printAnimalData();
            writeAnimalDataToFile("resources/animals/logData.txt", animal, count + 1);
            animalsMap.computeIfAbsent(animal.getClassName(), item -> new ArrayList<>()).add(animal);
            count++;
        } while (count < 10);

        writeDelimiterToFile("resources/animals/logData.txt");
        return animalsMap;
    }
}
