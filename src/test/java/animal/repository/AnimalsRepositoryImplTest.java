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
    List<Animal> animals = new ArrayList<>();
    SearchService searchService = new SearchServiceImpl();
    AnimalsRepositoryImpl animalsRepository = new AnimalsRepositoryImpl(searchService);


    public AnimalsRepositoryImplTest () {
        animals.add(new Cat("Порода 1", "Имя 1", "Характер 1" ,30.0, LocalDate.of(2000, 1, 1)));
        animals.add(new Cat("Порода 2", "Имя 2", "Характер 2" ,30.0, LocalDate.of(2004, 1, 1)));
        animals.add(new Dog("Порода 3", "Имя 3", "Характер 3" ,30.0, LocalDate.of(1988, 1, 1)));
        animals.add(new Dog("Порода 4", "Имя 4", "Характер 4" ,30.0, LocalDate.of(1992, 1, 1)));
        animals.add(new Dog("Порода 5", "Имя 5", "Характер 5" ,30.0, LocalDate.of(1993, 1, 1)));
    }

    @Test
    @DisplayName("Проверка метода AnimalsRepositoryImpl, в список попадают только животные родившиеся в високосный год")
    void findLeapYearNamesTest() {
        assertEquals(animalsRepository.findLeapYearNames(animals).size(), 4);
    }

    @Test
    @DisplayName("Проверка метода findOlderAnimal, в список попадают только животные старше 25 лет")
    void findOlderAnimalTest() {
        assertEquals(animalsRepository.findOlderAnimal(animals, 25).size(), 3);
    }

    @Test
    @DisplayName("Проверка метода findDuplicate, найдено 2 дубля Cat и 3 Dog")
    void findDuplicateTest() {
        Map<String, Integer> duplicatesMap = animalsRepository.findDuplicate(animals);
        assertEquals(duplicatesMap.get("Cat"), 2);
        assertEquals(duplicatesMap.get("Dog"), 3);
    }
}