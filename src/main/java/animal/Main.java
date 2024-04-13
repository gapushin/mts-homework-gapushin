package animal;

import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;
import animal.search.SearchService;
import animal.search.SearchServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CreateAnimalService createAnimalService = new CreateAnimalService();
        CreateAnimalServiceImpl createAnimalServiceImp = new CreateAnimalServiceImpl();

        createAnimalService.createAnimals();
        System.out.println("— — — — — — — — — —");

        createAnimalServiceImp.createAnimals();
        System.out.println("— — — — — — — — — —");

        createAnimalServiceImp.createAnimals(5);

        Cat cat1 = new Cat("Мэйнкун", "Барсик", "Задумчивый", 10.0, LocalDate.now());
        Cat cat2 = new Cat("Мэйнкун", "Мусик", "Задумчивый", 1000.0,null);
        SearchService searchService = new SearchServiceImpl();

        try {
            searchService.checkLeapYearAnimal(cat1);
        } catch (InvalidAnimalBirthDateException ex) {
            throw new InvalidAnimalException("Работа метода завершилась с ошибкой: " + ex.getMessage());
        }

        try {
            searchService.checkLeapYearAnimal(cat2);
        } catch (InvalidAnimalBirthDateException ex) {
            throw new InvalidAnimalException("Работа метода завершилась с ошибкой: " + ex.getMessage());
        }

        try {
            searchService.checkLeapYearAnimal(null);
        } catch (InvalidAnimalBirthDateException ex) {
            throw InvalidAnimalException.emptyObject();
        }
    }
}
