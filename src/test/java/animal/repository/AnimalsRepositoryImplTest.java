package animal.repository;

import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.search.SearchService;
import animal.search.SearchServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsRepositoryImplTest {
    List<Animal> animals;
    SearchService searchService;
    AnimalsRepositoryImpl animalsRepository;
    public AnimalsRepositoryImplTest () {
        animals = new ArrayList<>();
        searchService = new SearchServiceImpl();
        animalsRepository = new AnimalsRepositoryImpl(searchService);

        animals.add(new Cat("Порода 1", "Имя 1", "Характер 1" ,40.0, LocalDate.of(2000, 1, 1)));
        animals.add(new Cat("Порода 2", "Имя 2", "Характер 2" ,50.0, LocalDate.of(2004, 1, 1)));
        animals.add(new Cat("Порода 2", "Имя 3", "Характер 2" ,30.0, LocalDate.of(2003, 1, 1)));
        animals.add(new Cat("Порода 2", "Имя 4", "Характер 2" ,30.0, LocalDate.of(2003, 1, 1)));
        animals.add(new Cat("Порода 2", "Имя 5", "Характер 2" ,30.0, LocalDate.of(2003, 1, 1)));
        animals.add(new Dog("Порода 3", "Имя 3", "Характер 3" ,20.0, LocalDate.of(1988, 1, 1)));
        animals.add(new Dog("Порода 3", "Имя 3", "Характер 3" ,30.0, LocalDate.of(1988, 1, 1)));
        animals.add(new Dog("Порода 5", "Имя 5", "Характер 5" ,30.0, LocalDate.of(1993, 1, 1)));
    }

    @Test
    @DisplayName("Проверка метода AnimalsRepositoryImpl, в список попадают только животные родившиеся в високосный год")
    void findLeapYearNamesTest() {
        Map<String, LocalDate> animalsMap = animalsRepository.findLeapYearNames(animals);
        Map<String, LocalDate> target = new HashMap<>();

        System.out.println(animalsMap);
        target.put("Cat " + "Имя 1 ", LocalDate.of(2000, 1, 1));
        target.put("Dog " + "Имя 3 ", LocalDate.of(1988, 1, 1));
        target.put("Cat " + "Имя 2 ", LocalDate.of(2004, 1, 1));

        assertTrue(animalsMap.values().containsAll(target.values()) && animalsMap.size() == target.size());
    }

    @Test
    @DisplayName("Проверка метода findOlderAnimal, в список попадают только животные старше 25 лет")
    void findOlderAnimalTest() {
        Map<Animal, Integer> map = animalsRepository.findOlderAnimal(animals, 25);
        Map<Animal, Integer> target = new HashMap<>();

        System.out.println(map);
        target.put(animals.get(7), 1993);
        target.put(animals.get(6), 1988);
        target.put(animals.get(5), 1988);

        assertTrue(map.values().containsAll(target.values()) && map.size() == target.size());
    }

    @Test
    @DisplayName("Проверка метода findDuplicate, найдено 2 дубля Cat и 3 Dog")
    void findDuplicateTest() {
        Map<String, Integer> duplicatesMap = animalsRepository.findDuplicate(animals);
        assertEquals(duplicatesMap.get("Cat"), 5);
        assertEquals(duplicatesMap.get("Dog"), 3);
    }

    @Test
    @DisplayName("Проверка метода findAverageAge, найдено корректное среднее значение возраста")
    void findAverageAgeTest() {
        assertEquals(animalsRepository.findAverageAge(animals), 26.25);
    }

    @Test
    @DisplayName("Проверка метода findOldAndExpensive")
    void findOldAndExpensiveTest() {
        List<Animal> result = animalsRepository.findOldAndExpensive(animals);
        List<Animal> target = new ArrayList<>();

        System.out.println(result);

        target.add(animals.get(0));
        target.add(animals.get(1));

        assertTrue(result.containsAll(target) && result.size() == target.size());
    }

    @Test
    @DisplayName("Проверка метода findMinConstAnimals")
    void findMinConstAnimalsTest() {
        List<String> result = animalsRepository.findMinConstAnimals(animals);
        List<String> target = new ArrayList<>();

        System.out.println(result);

        target.add("Имя 4");
        target.add("Имя 3");
        target.add("Имя 3");

        assertTrue(result.containsAll(target) && result.size() == target.size());
    }
}