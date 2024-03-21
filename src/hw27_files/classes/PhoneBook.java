package hw27_files.classes;

import hw27_files.exceptions.PhoneNumberAddError;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, Contact> phonesAndContacts = new HashMap<>();

    public void createContact(String phoneNumber, String name, String surname) throws PhoneNumberAddError {
        if(phonesAndContacts.containsKey(phoneNumber)){
            throw new PhoneNumberAddError("Указанный номер уже присутствует в контактах");
        }
        phonesAndContacts.put(phoneNumber, new Contact(name,surname));
    }

    public void createContact(String phoneNumber, Contact contact) throws PhoneNumberAddError {
        if(phonesAndContacts.containsKey(phoneNumber)){
            throw new PhoneNumberAddError("Указанный номер уже присутствует в контактах");
        }
    }


}
