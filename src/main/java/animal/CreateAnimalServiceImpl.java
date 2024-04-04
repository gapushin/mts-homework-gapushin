package animal;

public class CreateAnimalServiceImpl implements IAnimalService {
    public void createAnimals(int length) {
        for (int i = 0; i < length; i++) {
            this.createRandomAnimal();
            i++;
        }
    }

    @Override
    public void createAnimals() {
        int count = 0;

        do {
            this.createRandomAnimal();
            count++;
        } while (count < 10);
    }
}
