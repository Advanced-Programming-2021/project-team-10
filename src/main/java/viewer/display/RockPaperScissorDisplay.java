package viewer.display;

import controller.enums.rockpaperscissor.GameError;
import controller.enums.rockpaperscissor.GameMessages;

public class RockPaperScissorDisplay {
    public static  void display(GameMessages message){
        System.out.println(message.toString());
    }
    public static void display(GameError error){
        System.out.println(error.toString());
    }
}
