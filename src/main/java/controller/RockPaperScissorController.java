package controller;

import controller.enums.PlayerOrientation;


public class RockPaperScissorController {
    public static PlayerOrientation recognizeGameWinner(String firstPlayerTool, String secondPlayerTool) {
        if (firstPlayerTool.equals(secondPlayerTool)) return PlayerOrientation.None;
        else if (firstPlayerTool.equals("paper")) {
            if (secondPlayerTool.equals("rock")) {
                return PlayerOrientation.PLAYER_ONE;
            } else {
                return PlayerOrientation.PLAYER_TWO;
            }
        } else if (firstPlayerTool.equals("rock")) {
            if (secondPlayerTool.equals("scissor")) {
                return PlayerOrientation.PLAYER_ONE;
            } else {
                return PlayerOrientation.PLAYER_TWO;
            }
        } else {
            if (secondPlayerTool.equals("paper")) {
                return PlayerOrientation.PLAYER_ONE;
            } else {
                return PlayerOrientation.PLAYER_TWO;
            }
        }
    }
}

