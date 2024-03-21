package hw27_files.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Contact {
    private String name;
    private String surname;
    private String nickName;
    //private final Map<String, String> phones = new TreeMap<>();
    //private final List<String> emails = new ArrayList<>();
    private LocalDate birthDay;

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
