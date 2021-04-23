package Model;

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

    public User(String username, String nickname, String password, int score) {
        setUsername(username);
        setNickname(nickname);
        setPassword(password);
        setScore(score);
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

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static ArrayList<User> getAllUsers() {
        return ALL_USERS;
    }

    private void setPassword(String password) {
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

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isPasswordMatch(String password) {
        return password.equals(this.password);
    }
}

