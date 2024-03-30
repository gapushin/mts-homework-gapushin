package animal;

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
}
