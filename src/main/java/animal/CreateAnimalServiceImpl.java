package animal;

public class CreateAnimalServiceImpl implements IAnimalService {
    public void createAnimals(int length) {
        for (int i = 0; i < length; i++) {
            createRandomAnimal();
            i++;
        }
    }

    @Override
    public void createAnimals() {
        int count = 0;

        do {
            createRandomAnimal();
            count++;
        } while (count < 10);
    }
}
