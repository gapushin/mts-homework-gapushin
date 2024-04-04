package animal;

import java.time.LocalDate;

public interface IAnimal {
    String getBreed();
    String getName();
    Double getCost();
    String getCharacter();

    LocalDate getBirthDate();
    void setBirthDate(LocalDate value);

    void printAnimalData();

}
