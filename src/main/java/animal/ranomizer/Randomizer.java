package animal.ranomizer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Randomizer implements IRandomizer {
    final String[] breedValues = {"Порода 1", "Порода 2", "Порода 3", "Порода 4", "Порода 5"};
    final String[] nameValues = {"Имя 1", "Имя 2", "Имя 3", "Имя 4", "Имя 5"};
    final Double[] costValues = {10.0, 100.0, 1000.0, 10000.0, 100000.0};
    final String[] characterValues = {"Добрый", "Злой", "Веселый", "Радостный", "Другой"};

    Integer getRandomIndex(int arrLength) {
        return (int)Math.floor(Math.random() * arrLength);
    }

    @Override
    public String getRandomBreed() {
        return breedValues[getRandomIndex(breedValues.length)];
    }

    @Override
    public Double getRandomCoast() {
        return costValues[getRandomIndex(costValues.length)];
    }

    @Override
    public String getRandomName() {
        return nameValues[getRandomIndex(nameValues.length)];
    }

    @Override
    public String getRandomCharacter() {
        return characterValues[getRandomIndex(characterValues.length)];
    }

    @Override
    public LocalDate getRandomBirthDate() {
        Random random = new Random();
        int year = 1970 + random.nextInt(55);
        int month = random.nextInt(11) + 1;
        int day = random.nextInt(27) + 1;

        LocalDate localDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String localDateString = localDate.format(formatter);

        return LocalDate.parse(localDateString, formatter);
    }
}
