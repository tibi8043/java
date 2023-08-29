package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //Streams
        System.out.println("---STREAMS---");

        List <Cat> cats = makingList();


        List <Cat> maleCats = cats.stream()
                .filter(cat -> cat.getGender().equals(Gender.MALE))
                .collect(Collectors.toList());

        //print
        maleCats.forEach(System.out::println);
        System.out.println("\nSorted Cats:");
        List <Cat> sortedCats = cats.stream()
                .sorted(Comparator.comparing(Cat::getName).thenComparing((Cat::getHeight)))
                .collect(Collectors.toList());

        sortedCats.forEach(System.out::println);

        System.out.println("\nReverse Sroting cats");
        List <Cat> sortedCatsReverse = sortedCats.stream()
                .sorted(Comparator.comparing(Cat::getName).reversed())
                .collect(Collectors.toList());

        sortedCatsReverse.forEach(System.out::println);

        //Mathces

        System.out.println("\nMatches:");
        boolean allOlderThan3 = cats.stream()
                .allMatch(cat -> cat.getAge()>3);
        System.out.println("All of the Cats are older than 3 : "+allOlderThan3);


        boolean thereAreOlderThan3 = cats.stream()
                .anyMatch(cat -> cat.getAge()>3);
        System.out.println("We have some Cats that older than 3 : "+thereAreOlderThan3);

        boolean nonAreOlderThan3 = cats.stream()
                .noneMatch(cat -> cat.getAge()>3);
        System.out.println("We dont have any Cats that older than 3 : "+nonAreOlderThan3);

        //Oldest cat
        System.out.println("\nMin,Max");
        Optional<Cat> highestCat = cats.stream()
                .max(Comparator.comparing(Cat::getHeight));

        System.out.println("The highest Cat is "+ highestCat);

        //Youngest cat

        cats.stream()
                .min(Comparator.comparing(Cat::getAge))
                .ifPresent(x-> System.out.println("The youngest cat is "+x));
        //Group by
        //Group by gender and sorted by height.
        System.out.println("\nGroup by gender and sorted by height");
        Map<Gender, List<Cat>> groupByGender = cats.stream()
                .collect(Collectors.groupingBy(Cat::getGender));
        groupByGender.forEach((gender, cat) ->{
            System.out.println(gender);
            cat.stream()
                    .sorted(Comparator.comparing(Cat::getHeight))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        });

        //map
        System.out.println("\nMap:");
        cats.stream()
                .map(Cat::getHeight)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //The oldest male cat's name which is higher than 21
        cats.stream()
                .filter(cat -> cat.getGender().equals(Gender.MALE) && cat.getHeight()>21)
                .max(Comparator.comparing(Cat::getAge))
                .ifPresent(cat -> System.out.println("the specific cat's name is :"+cat.getName()));


    }
    private static List<Cat> makingList(){
        return List.of(
                new Cat("Mirci",3,23,11,Gender.MALE),
                new Cat("Pamacs",5,22,15,Gender.MALE),
                new Cat("Pelyhes",3,26,14,Gender.MALE),
                new Cat("Cirmi",2,23,13,Gender.FEMALE),
                new Cat("Csoki",3,26,17,Gender.MALE)

        );
    }
}