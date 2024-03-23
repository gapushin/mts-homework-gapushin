package animal;

public class Main {
    public static void main() {
        CreateAnimalService createAnimalService = new CreateAnimalService();
        CreateAnimalServiceImpl createAnimalServiceImp = new CreateAnimalServiceImpl();

        createAnimalService.createAnimals();
        System.out.println("— — — — — — — — — —");

        createAnimalServiceImp.createAnimals();
        System.out.println("— — — — — — — — — —");

        createAnimalServiceImp.createAnimals(15);
    }
}
