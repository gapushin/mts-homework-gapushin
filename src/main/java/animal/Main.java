package animal;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalServiceImp = new CreateAnimalServiceImpl();

        createAnimalServiceImp.createAnimals();
        createAnimalServiceImp.createAnimals(5);
        System.out.println("— — — — — — — — — —");

        ResultReader resultReader = new ResultReader();
        resultReader.logAnimalDataFromFile("resources/results/findOlderAnimals.json");
        System.out.println("— — — — — — — — — —");

        resultReader.logFileStringsCount("resources/animals/logData.txt");
    }
}
