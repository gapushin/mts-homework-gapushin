package animal.search;

import animal.Animal;
import animal.exceptions.InvalidAnimalBirthDateException;
import animal.exceptions.InvalidAnimalException;

public class SearchServiceImpl implements SearchService {
    @Override
    public boolean checkLeapYearAnimal (Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        if (animal == null) {
           throw InvalidAnimalException.emptyObject();
        }

        if (animal.getBirthDate() == null) {
            throw InvalidAnimalBirthDateException.emptyBirthdate(animal.getName());
        }

        final int year = animal.getBirthDate().getYear();
        //        System.out.println(isLeapYear ?
//                String.format("%s %s был рожден в високосный год", animal.getClassName(), animal.getName()) :
//                String.format("%s %s не был рожден в високосный год", animal.getClassName(), animal.getName()));

        return year > 1584 &&
                ((year % 400 == 0) || (year %4 == 0 && year % 100 != 0));
    }
}
