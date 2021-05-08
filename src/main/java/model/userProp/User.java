package model.userProp;

import model.cards.cardsProp.Card;

import java.util.ArrayList;

public class User {

    private static final ArrayList<User> ALL_USERS;

    static {
        ALL_USERS = new ArrayList<>();
    }

    private String username;
    private String nickname;
    private String password;
    private int score;
    private int balance;
    private Deck activeDeck;
    private final ArrayList<Deck> allDecks;
    private final ArrayList<Card> userCardCollection;

    {
        allDecks = new ArrayList<>();
        userCardCollection = new ArrayList<>();
        activeDeck = null;
    }

    {
        balance = 10000000;
        score = 0;
    }

    public User(String username, String nickname, String password) {
        setUsername(username);
        setNickname(nickname);
        setPassword(password);
        ALL_USERS.add(this);
    }

    public static User getUserByUserInfo(String info, UserInfoType userInfoType) {
        switch (userInfoType) {
            case USERNAME: {
                for (User user : ALL_USERS) {
                    if (user.getUsername().equals(info)) {
                        return user;
                    }
                }
                break;
            }
            case NICKNAME: {
                for (User user : ALL_USERS) {
                    if (user.getNickname().equals(info))
                        return user;
                }
                break;
            }
        }
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return ALL_USERS;
    }

    public Deck getDeckByName(String name) {
        for (Deck deck : allDecks) {
            if (deck.getName().equals(name)) {
                return deck;
            }
        }
        return null;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score = score;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int cost) {
        this.balance += cost;
    }

    public boolean isPasswordMatch(String password) {
        return password.equals(this.password);
    }

    public Deck getActiveDeck() {
        return activeDeck;
    }

    public ArrayList<Deck> getAllDecks() {
        return allDecks;
    }

    public void setActiveDeck(Deck activeDeck) {
        if (this.activeDeck != null) this.activeDeck.setDeckActivated(false);
        this.activeDeck = activeDeck;
        if (activeDeck != null ) activeDeck.setDeckActivated(true);
    }

    public ArrayList<Card> getUserCardCollection() {
        return userCardCollection;
    }

    public boolean isCardInUserCardCollection(Card card) {
        return !userCardCollection.contains(card);
    }
}

