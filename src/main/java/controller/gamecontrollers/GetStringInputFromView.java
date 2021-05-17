package controller.gamecontrollers;

import model.enums.GameEnums.RequestingInput;
import viewer.game.GetStringInput;

public class GetStringInputFromView {
    public static String getInputFromController(RequestingInput message) {
        return GetStringInput.getInput(message);
    }
}
