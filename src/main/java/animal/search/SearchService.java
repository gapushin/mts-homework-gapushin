package animal.search;

import animal.IAnimal;
import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;

public interface SearchService {
    boolean checkLeapYearAnimal (IAnimal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException;
}
