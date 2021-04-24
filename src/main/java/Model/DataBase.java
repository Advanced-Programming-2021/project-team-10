package Model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class DataBase {
    private static DataBase instance;

    private DataBase() {
    }

    public static DataBase getInstance() {
        if (instance == null) instance = new DataBase();
        return instance;
    }

    public void restoreDate() {
        try (CSVReader reader = new CSVReader(new FileReader("SpellTrap.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                new MagicCard(lineInArray[0], lineInArray[1],
                        lineInArray[2], lineInArray[3],
                        lineInArray[4], Integer.parseInt(lineInArray[5]));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
