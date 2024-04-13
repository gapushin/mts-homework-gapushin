package animal;

import animal.repository.AnimalsRepositoryImpl;
import animal.search.SearchService;
import animal.search.SearchServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        SearchService searchService = new SearchServiceImpl();
        AnimalsRepositoryImpl animalsRepository = new AnimalsRepositoryImpl(searchService);

        Map<String, List<Animal>> animalsMap = createAnimalService.createAnimals(100);

        for (Map.Entry<String, List<Animal>> entry : animalsMap.entrySet()) {
            Map<String, LocalDate> namesMap = animalsRepository.findLeapYearNames(entry.getValue());
            System.out.println(namesMap);
        }

        System.out.println("———————————————————");

        for (Map.Entry<String, List<Animal>> entry : animalsMap.entrySet()) {
            Map<Animal, Integer> agesMap = animalsRepository.findOlderAnimal(entry.getValue(), 20);
            System.out.println(agesMap);
        }

        System.out.println("———————————————————");
        for (Map.Entry<String, List<Animal>> entry : animalsMap.entrySet()) {
            Map<String, Integer> duplicatesMap = animalsRepository.findDuplicate(entry.getValue());
            System.out.println(duplicatesMap);
        }

    }
}
