package hw30_windows;

import hw30_windows.classes.DataBase;
import hw30_windows.classes.MainFrame;


/**
 *
 * Попробовать сделать подобное окно, с данными из файла spb_top.csv или spb_top.txt, группировать по последнему и/или первому столбцу
 */
public class Main {
    private static final DataBase db = new DataBase();
    private static MainFrame frame;
    public static void main(String[] args) {
        db.initFromCSVFile("src/hw30_windows/data/spb_top.csv");

        frame = new MainFrame("Список поликлиник с услугами");
        frame.connectToDb(db);
        frame.initLeftList();
        frame.setVisible(true);
    }
}
