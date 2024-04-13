package animal.search;

import animal.Animal;
import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;

public interface SearchService {
    boolean checkLeapYearAnimal (Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException;
}
