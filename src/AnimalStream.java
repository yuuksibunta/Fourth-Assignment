import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalStream {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Animal("ヘビ", "爬虫類", 2),
                new Animal("ライオン", "哺乳類", 5),
                new Animal("キリン", "哺乳類", 8),
                new Animal("カラス", "鳥類", 10),
                new Animal("亀", "爬虫類", 20),
                new Animal("サメ", "軟骨魚類", 6)
        );

        List<Animal> birds = animals.stream()
                .filter(animal -> animal.getSpecies().equals("鳥類"))
                .toList();

        List<Animal> sortedByAge = animals.stream()
                .sorted(Comparator.comparingInt(Animal::getAge))
                .toList();

        String reptilesString = birds.stream()
                .map(Animal::getName)
                .collect(Collectors.joining("と"));

        System.out.println("鳥類の動物:"+ reptilesString);
        System.out.println("年齢(若い順)");

        for (int i = 0; i < sortedByAge.size(); i++) {
            Animal animal = sortedByAge.get(i);
            System.out.println((i + 1) + "、" + animal.toString());
        }
    }
}