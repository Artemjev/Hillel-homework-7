package com.hillel.artemjev.userparse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//https://prnt.sc/w2styx - не стал усложнять задачу и делать через интерфейс.
public class UserParser {

    private static final String USER_REGEX_PATTERN = "(?:(\\w*):)?(\\w+)(?:@(\\w+))?";

    private Pattern pattern;

    public UserParser() {
        this.pattern = Pattern.compile(USER_REGEX_PATTERN);
    }

//    User parse(String userStr) - если на вход получил невалидную строку, то он возвращает null.
//    https://prnt.sc/w2s0zx
    public User parse(String userStr) {
        User user = null;

        if (validateUserString(userStr)) {
            Matcher matcher = pattern.matcher(userStr);

            if ((matcher.find())) {
                String username = matcher.group(2);
                String nickname = (matcher.group(1) == null) ? username : matcher.group(1);
                String password = matcher.group(3);
                user = new User(username, nickname, password);
            }
        }
        return user;
    }

//    https://prnt.sc/w2s29v - сделал согласно заданию (метод возвразщает интерфейс).
//    Но вопрос для меня остается открытым (хорошо ли, что метод возвращает итерфейс?).
//    В принцине, получается, что результат выполнения этого метода мы сможем присваить только переменной,
//    тип которой - интерфейс (List<User>), что и не плохо по принципу DI.
    public List<User> parseList(String usersString) {
        List<User> userList = new ArrayList<User>();
        List<String> userStrList = getUserStringsList(usersString);
        for (String s : userStrList) {
            userList.add(parse(s));
        }
        return userList;
    }

    //--------------------------------------------------------------------------------
    private List<String> getUserStringsList(String usersStr) {
        String[] userStringsArray = usersStr.split(",");
        List<String> userStringsList = new ArrayList<String>();

        for (String str : userStringsArray) {
            str = str.trim();
            if (str.length() > 0) {
                userStringsList.add(str);
            }
        }
        return userStringsList;
    }

    private boolean validateUserString(String userStr) {
        return userStr.matches(USER_REGEX_PATTERN);
    }
}
