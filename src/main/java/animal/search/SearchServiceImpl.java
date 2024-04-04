package animal.search;

import animal.IAnimal;
import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;

public class SearchServiceImpl implements SearchService {
    @Override
    public boolean checkLeapYearAnimal (IAnimal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        if (animal == null) {
           throw InvalidAnimalException.emptyObject();
        }

        if (animal.getBirthDate() == null) {
            throw InvalidAnimalBirthDateException.emptyBirthdate(animal.getName());
        }

        final int year = animal.getBirthDate().getYear();
        boolean isLeapYear = year > 1584 &&
                ((year % 400 == 0) || (year %4 == 0 && year % 100 != 0));
        System.out.println(isLeapYear ?
                String.format("%s был рожден в високосный год", animal.getName()) :
                String.format("%s не был рожден в високосный год", animal.getName()));

        return isLeapYear;
    }
}
