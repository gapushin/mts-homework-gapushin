package animal.repository;

import animal.Animal;
import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;
import animal.search.SearchService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalsRepositoryImpl implements  AnimalRepository {

    private final SearchService searchService;
    public AnimalsRepositoryImpl (SearchService searchService) {
        this.searchService = searchService;
    }
    @Override
        public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) {
        Map<String, LocalDate> map = new HashMap<>();

        animals.forEach(animal -> {
            try {
                if (this.searchService.checkLeapYearAnimal(animal)) {
                    map.put(String.format("%s %s ", animal.getClassName(), animal.getName()), animal.getBirthDate());
                }
            } catch (InvalidAnimalBirthDateException e) {
                throw new InvalidAnimalException("Работа метода завершилась с ошибкой: " + e.getMessage());
            }
        });

        return  map;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, Integer minAge) {
        Map<Animal, Integer> map = new HashMap<>();

        animals.forEach(animal -> {
            if (animal.getBirthDate().getYear() < LocalDate.now().getYear() - minAge) {
                map.put(animal, animal.getBirthDate().getYear());
            }
        });

        return  map;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        Map<String, Integer> map = new HashMap<>();

        animals.forEach(animal -> map.put(animal.getClassName(), map.getOrDefault(animal.getClassName(), 0) + 1));

        return  map;
    }
}
