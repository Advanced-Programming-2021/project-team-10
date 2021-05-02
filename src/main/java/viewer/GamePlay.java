package viewer;

import controller.ClearScreen;
import controller.GamePlayGeneralController;
import controller.ImportScanner;
import controller.enums.PlayerEnum;
import model.gameprop.Game;
import model.gameprop.Player;
import model.gameprop.gamestage.GameSideStage;

public class  GamePlay {

    private Game game;
    private GamePlayGeneralController generalController;

    public GamePlay() {
        this.game = new Game();
        generalController = new GamePlayGeneralController(game);
    }

    private void recognizeCommand(String command) {
        //TODO test show grave yard
        if (command.matches(Regex.showGraveYard)) {
            if (command.contains("opponent")) {
                generalController.showGraveYard(PlayerEnum.OPPONENT);
            } else {
                generalController.showGraveYard(PlayerEnum.FRIEND);
            }
            game.setGameSideStage(GameSideStage.GRAVE_YARD_SHOW);
        }
    }


    public void run() {
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (game.getGameSideStage() == GameSideStage.NONE) {
                generalController.showGameBoard();
                recognizeCommand(command);
            } else {
                if (command.trim().equals("back")) {
                    game.setGameSideStage(GameSideStage.NONE);
                    ClearScreen.clearScreen(); //visible in terminal
                }
            }
        }
    }
}
