package model;

import com.google.gson.Gson;
import model.cards.cardsProp.Card;
import model.cards.cardsProp.MagicCard;
import model.cards.cardsProp.MonsterCard;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class DataBase {
    private static DataBase instance;

    private DataBase() {
    }

    public static DataBase getInstance() {
        if (instance == null) instance = new DataBase();
        return instance;
    }

    public void restoreDate() {
        ArrayList<Card> magicCards = new ArrayList<>();
        ArrayList<Card> monsterCards = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("csvFile\\SpellTrap.csv"))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                MagicCard magicCard = new MagicCard(lineInArray[0], lineInArray[1],
                        lineInArray[2], lineInArray[3],
                        lineInArray[4], lineInArray[5]);
                magicCards.add(magicCard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (CSVReader reader = new CSVReader(new FileReader("csvFile\\Monster.csv"))) {
            String[] infoRow;
            reader.readNext(); // dummy read to skip the title row
            while ((infoRow = reader.readNext()) != null) {
                MonsterCard monsterCard = new MonsterCard(infoRow[0], infoRow[1], infoRow[2],
                        infoRow[3], infoRow[4], infoRow[5],
                        infoRow[6], infoRow[7], infoRow[8]);
                monsterCards.add(monsterCard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = new Gson().toJson(magicCards);
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("jsonResources\\MagicCard.json"), StandardCharsets.UTF_8));
            writer.write(json);
        } catch (IOException ex) {
            // Report
        } finally {
            try {
                assert writer != null;
                writer.close();} catch (Exception ex) {/*ignore*/}
        }
        json = new Gson().toJson(monsterCards);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("jsonResources\\MonsterCard.json"), StandardCharsets.UTF_8));
            writer.write(json);
        } catch (IOException ex) {
            // Report
        } finally {
            try {
                writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}
