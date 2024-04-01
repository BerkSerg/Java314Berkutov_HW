package hw30_windows.classes;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Map String - name
 * Hospital - class with information
 *
 *
 * """XXI век"" Медицинский центр"" АНО";
 * 175400, Новгородская обл, Валдай г, Ленина ул, дом № 39;
 * +7 (812) 4542121;
 * Амбулаторно-поликлиническая помощь, Помощь на дому в пределах административной границы города
 */



public class DataBase {

    private final Map<String, Hospital> db = new TreeMap<>();

    public void initFromCSVFile(String path){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("windows-1251")));

            String line = br.readLine();
            while (line != null){
                if(!line.isEmpty()) {
                    Hospital hospital = Hospital.getByString(line);
                    if(hospital != null) {
                        db.put(hospital.getName(), hospital);
                    }
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String[] getNames() {
        String[] result = new String[db.size()];
        db.keySet().toArray(result);
        return result;
    }

    public Hospital getHospitalByName(String hospitalName) {
        return db.get(hospitalName);
    }
}
