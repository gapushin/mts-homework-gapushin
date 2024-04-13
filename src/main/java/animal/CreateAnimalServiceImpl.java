package animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements AnimalService {
    public Map<String, List<Animal>> createAnimals(int length) {
        Map<String, List<Animal>> animalsMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Animal animal = createRandomAnimal();

            animalsMap.computeIfAbsent(animal.getClassName(), item -> new ArrayList<>()).add(animal);
            i++;
        }

        return animalsMap;
    }

    @Override
    public Map<String, List<Animal>> createAnimals() {
        int count = 0;
        Map<String, List<Animal>> animalsMap = new HashMap<>();

        do {
            Animal animal = createRandomAnimal();
            animalsMap.computeIfAbsent(animal.getClassName(), item -> new ArrayList<>()).add(animal);
            count++;
        } while (count < 10);

        return animalsMap;
    }
}
