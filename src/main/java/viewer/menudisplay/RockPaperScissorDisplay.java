package viewer.menudisplay;

import controller.enums.rockpaperscissor.PaperRockScissorError;
import controller.enums.rockpaperscissor.GameMessages;

public class RockPaperScissorDisplay {
    public static  void display(GameMessages message){
        System.out.println(message.toString());
    }
    public static void display(PaperRockScissorError error){
        System.out.println(error.toString());
    }
}
