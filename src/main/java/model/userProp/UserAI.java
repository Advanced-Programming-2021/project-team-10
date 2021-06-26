package model.userProp;

public class UserAI extends FatherUser{
    private static UserAI instance;

    {
        score = 0;
//        activeDeck = randomValidDeck();
        nickname = "Robot";
    }

    public static UserAI getInstance() {
        if (instance == null) {
            instance = new UserAI();
        }
        return instance;
    }

//    private Deck randomValidDeck() {
//        return new Deck();
//    }
}
