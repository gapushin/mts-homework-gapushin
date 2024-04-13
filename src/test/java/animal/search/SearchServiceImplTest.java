package animal.search;

import animal.Cat;
import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;
import animal.ranomizer.Randomizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceImplTest {
    SearchService searchService = new SearchServiceImpl();
    Randomizer randomizer = new Randomizer();
    Cat cat = new Cat(randomizer.getRandomBreed(), randomizer.getRandomName(), randomizer.getRandomCharacter(), randomizer.getRandomCoast(), randomizer.getRandomBirthDate());

    @ParameterizedTest
    @DisplayName("Проверка метода checkLeapYearAnimal, високосный год, Позитивный тест")
    @ValueSource(ints = {2024, 2020, 2016, 2012, 2008})
    void checkIsLeapYearAnimal (int year) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        System.out.println(year);
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        assertTrue(searchService.checkLeapYearAnimal(cat));
    }

    @ParameterizedTest
    @DisplayName("Проверка метода checkLeapYearAnimal, НЕ високосный год, Позитивный тест")
    @ValueSource(ints = {2023, 2021, 2017, 2011, 2009})
    void checkIsNotLeapYearAnimal (int year) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        System.out.println(year);
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        assertFalse(searchService.checkLeapYearAnimal(cat));
    }

    @Test
    @DisplayName("Проверка метода checkLeapYearAnimal, дата рождения не указана")
    void checkNullBirthDay () {
        cat.setBirthDate(null);
        assertThrows(InvalidAnimalBirthDateException.class, () -> searchService.checkLeapYearAnimal(cat));
    }

    @Test
    @DisplayName("Проверка метода checkLeapYearAnimal, не передан объект животного")
    void checkNullAnimalObject () {
        assertThrows(InvalidAnimalException.class, () -> searchService.checkLeapYearAnimal(null));
    }
}