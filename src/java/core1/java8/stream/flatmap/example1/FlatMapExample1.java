package java.core1.java8.stream.flatmap.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample1 {

    public static void main(String[] args) {

        Developer developer1 = new Developer();
        developer1.setName("turan1");
        developer1.addBook("Java 8 in Action");
        developer1.addBook("Spring Boot in Action");
        developer1.addBook("Effective Java (3nd Edition)");

        Developer developer2 = new Developer();
        developer2.setName("turan2");
        developer2.addBook("Learning Python, 5th Edition");
        developer2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(developer1);
        list.add(developer2);

        Set<String> collect = list.stream()
                .map(Developer::getBook)                           //Stream <Set<String>>
                .flatMap(Collection::stream)                      // Stream<String>
                .filter(x -> !x.toLowerCase().contains("python")) // filter python book
                .collect(Collectors.toSet());                     // remove duplicated

        collect.forEach(System.out::println);
    }

}
