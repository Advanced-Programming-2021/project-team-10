package controller.enums.rockpaperscissor;

public enum GameMessages {
    PLAYER_ONE_CHOOSE("Player one Choose Your Weapon Rock, Paper Or Scissor"),
    PLAYER_TWO_CHOOSE("Player two Choose Your Weapon Rock, Paper Or Scissor"),
    DRAW_MESSAGE("The game result is draw try one more time"),
    PLAYER_ONE_WIN_MESSAGE("player one won"),
    PLAYER_TWO_WIN_MESSAGE("player one won");
    String messageToString;

    GameMessages(String messageToString) {
        this.messageToString = messageToString;
    }

    @Override
    public String toString() {
        return messageToString;
    }
}
