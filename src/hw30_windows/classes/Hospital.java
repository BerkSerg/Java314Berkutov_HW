package hw30_windows.classes;

import java.util.ArrayList;
import java.util.List;


/**
 * 1. Наименование ЛПУ
 * 2. Адрес
 * 3. телефон
 * 4. Виды помощи
 */
public class Hospital {
    public static String SEPARATOR = ";";

    private String name;
    private String address;
    private String phone;
    private final List<String> typeOfHelping = new ArrayList<>();

    public Hospital(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Hospital(String name, String address, String phone, List<String> split) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.typeOfHelping.addAll(split);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<String> getTypeOfHelping() {
        return new ArrayList<>(typeOfHelping);
    }

    public static Hospital getByString(String line) {
        String[] info = line.split(SEPARATOR);
        if(info.length < 4){
            return null;
        }
        return new Hospital(info[0], info[1], info[2], List.of(info[3].split(",")));
    }


}
