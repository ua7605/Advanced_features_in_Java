import streams.Gender;
import streams.Person;

import java.util.*;
import java.util.stream.Collectors;

public class main_streams
{
    public static void main(String[] args)
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("warren buffer", 120));
        personList.add(new Person("Bill gates", 200));
        personList.add(new Person("Jeff Bezos", 300));
        personList.add(new Person("Mark Zuckerberg", 600));

        List<Person> twoHunderClub = new ArrayList<>();

//        Filter the personList of people that have 200 or more Billions
        twoHunderClub = personList.stream()
                .filter(person -> person.getMoney() >= 200)
                .collect(Collectors.toList());
        twoHunderClub.forEach(System.out::println);

        System.out.println();
        System.out.println("Sort the map alphabetically");

//        Sort the map alphabetically.
        List<Person> sortedByName = personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        sortedByName.forEach(System.out::println);

        System.out.println();
        System.out.println("The combination of the two");

//        the combination of the two
        List<Person> filteredAndStoredList = personList.stream()
                .filter(person -> person.getMoney() >= 200)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        filteredAndStoredList.forEach(System.out::println);
        System.out.println("");

        System.out.println("New tutorial");
        System.out.println("");
//        Following another tutorial: https://www.youtube.com/watch?v=Q93JsQ8vcwY
        List<Person> personListAmicho = List.of(
                new Person("Vincent", 24, Gender.MALE),
                new Person("Jan", 60, Gender.MALE),
                new Person("Maria", 74, Gender.FEMALE),
                new Person("Charlotte", 25, Gender.FEMALE),
                new Person("Steve", 55, Gender.MALE),
                new Person("Lotte",44, Gender.FEMALE)
        );

        personListAmicho.forEach(System.out::println);

        List<Person> feamaleList = personListAmicho.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .collect(Collectors.toList());
        System.out.println("female list");
        feamaleList.forEach(System.out::println);

        System.out.println("");
        System.out.println("All match example ");

        boolean allMatch = personListAmicho.stream()
                .allMatch(person -> person.getAge() > 40);
        System.out.println(allMatch);

        boolean anyMatch = personListAmicho.stream()
                .anyMatch(person -> person.getAge() > 40);
        System.out.println(anyMatch);

        // none match
        boolean noneMatchOnAntonio = personListAmicho.stream()
                .noneMatch(person -> person.getName().equals("antonio"));
        System.out.println(noneMatchOnAntonio);

        // Max
        Optional<Person> oldestPerson = personListAmicho.stream()
                .max(Comparator.comparing(Person::getAge));
        oldestPerson.ifPresent(System.out::println);

        System.out.println("");
        System.out.println("Example of group");
        System.out.println("");

        Map<Gender, List<Person>> groupByGender = personListAmicho.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach(((gender, people) -> {
            System.out.println(gender);
            people.forEach(System.out::println);
            System.out.println();
        }));

        Optional<String> oldestFemalePerson = personListAmicho.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        System.out.println(oldestFemalePerson);

    }
}
