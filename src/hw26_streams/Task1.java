package hw26_streams;

import hw26_streams.classes.Person;
import hw26_streams.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 1.	Фильтрация и сборка:
 * o	Создайте список объектов Person с полями name, age и gender.
 * o	Используя Stream, отфильтруйте только женщин старше 18 лет.
 * o	Соберите их имена в новый список.
 */
public class Task1 {
    private final static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        initPersons();

        List<String> ladies = persons.stream()
                .filter(person -> person.getGender() == Gender.FEMALE && person.getAge() >= 18)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(ladies);

    }

    private static void initPersons() {
        persons.add(new Person("Дима", 20, Gender.MALE));
        persons.add(new Person("Оксана", 16, Gender.FEMALE));
        persons.add(new Person("Вася", 17, Gender.MALE));
        persons.add(new Person("Таня", 17, Gender.FEMALE));
        persons.add(new Person("Вика", 18, Gender.FEMALE));
        persons.add(new Person("Петя", 30, Gender.MALE));
        persons.add(new Person("Сережа", 33, Gender.MALE));
        persons.add(new Person("Лена", 35, Gender.FEMALE));
        persons.add(new Person("Даша", 27, Gender.FEMALE));
        persons.add(new Person("Саша", 16, Gender.MALE));
        persons.add(new Person("Виолетта Карловна", 55, Gender.FEMALE));
    }
}
