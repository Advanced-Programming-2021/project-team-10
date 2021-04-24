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
                              lineInArray[4], lineInArray[5]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(CSVReader reader = new CSVReader(new FileReader("Monster.csv"))) {
            String[] infoRow;
            reader.readNext(); // dummy read to skip the title row
            while ((infoRow = reader.readNext()) != null) {
                new MonsterCard(infoRow[0], infoRow[1], infoRow[2],
                        infoRow[3], infoRow[4], infoRow[5],
                        infoRow[6], infoRow[7], infoRow[8]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
