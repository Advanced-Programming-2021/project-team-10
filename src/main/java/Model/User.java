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

    public User(String username, String nickname, String password) {
        setUsername(username);
        setNickname(nickname);
        setPassword(password);
        ALL_USERS.add(this);
    }

    public static User getUserByUserInfo(String info, UserInfoType userInfoType) {
        switch (userInfoType) {
            case USERNAME -> {
                for (User user : ALL_USERS) {
                    if (user.getUsername().equals(info)) {
                        return user;
                    }
                }
            }
            case NICKNAME -> {
                for (User user : ALL_USERS) {
                    if (user.getNickname().equals(info))
                        return user;
                }
            }
        }
        return null;
    }


    private void setPassword(String password) {
        this.password = password;
    }

    private String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getNickname() {
        return nickname;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isPasswordMatch(String password) {
        return password.equals(this.password);
    }
}

