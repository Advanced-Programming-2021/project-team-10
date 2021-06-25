package controller.menues.menuhandlers.menucontrollers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.cards.cardsProp.Card;
import model.cards.cardsProp.MagicCard;
import model.cards.cardsProp.MonsterCard;
import viewer.Regex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class ImportExportMenuController {
    public static String update(String command) {
        String cardname = "a";
        if (command.matches("import card .+")) {
            Matcher matcher = Regex.getMatcher(command, "import card (.+)");
            if (matcher.find()) {
                cardname = matcher.group(1);
            }
            String path = "jsonResources\\ImportExport\\" + cardname + ".json";
            try {
                String json = new String(Files.readAllBytes(Paths.get(path)));
                Card card;
                if (json.contains("typeOfMagic")) {
                    card = new Gson().fromJson(json, MagicCard.class);
                } else {
                    card = new Gson().fromJson(json, MonsterCard.class);
                }
                if (card instanceof MagicCard) {
                    updateMagicCards((MagicCard) card);
                } else {
                    updateMonsterCards((MonsterCard) card);
                }
            } catch (IOException e) {
                return "could not import because there is no json file";
            }
            return "import done rerun the program";
        } else {
            Matcher matcher = Regex.getMatcher(command, "export card (.+)");
            if (matcher.find()) {
                cardname = matcher.group(1);
            }
            Card card = Card.getCardByName(cardname);
            if (card == null) {
                return "card not found";
            }
            try {
                File currentDirFile = new File(".");
                String helper = currentDirFile.getAbsolutePath();
                String path = helper.substring(0, helper.length() - 1);
                path = path + "jsonResources\\ImportExport\\" + cardname + ".json";
                File file = new File(path);
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(path);
                String json = new Gson().toJson(card);
                fileWriter.write(json);
                fileWriter.close();
            } catch (IOException e) {
                return "error occurred";
            }
            return "export done rerun the program";
        }
    }

    private static void updateMagicCards(MagicCard magicCard) {
        ArrayList<MagicCard> magicCards = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get("jsonResources\\MagicCard.json")));
            magicCards = new Gson().fromJson(json,
                    new TypeToken<List<MagicCard>>() {
                    }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!magicCards.contains(magicCard)) {
            magicCards.add(magicCard);
            String json = new Gson().toJson(magicCards);
            Writer writer;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("jsonResources\\MagicCard.json"), StandardCharsets.UTF_8));
                writer.write(json);
                writer.close();
            } catch (IOException ex) {
                //Report
            }
        }
    }

    private static void updateMonsterCards(MonsterCard monsterCard) {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get("jsonResources\\MonsterCard.json")));
            monsterCards = new Gson().fromJson(json,
                    new TypeToken<List<MonsterCard>>() {
                    }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!monsterCards.contains(monsterCard)) {
            monsterCards.add(monsterCard);
            String json = new Gson().toJson(monsterCards);
            try {
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("jsonResources\\MonsterCard.json"), StandardCharsets.UTF_8));
                writer.write(json);
            } catch (IOException ex) {
                //Report
            }
        }
    }
}
