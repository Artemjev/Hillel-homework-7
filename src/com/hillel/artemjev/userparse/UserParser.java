package com.hillel.artemjev.userparse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserParser {
    private String userRegExPattern = "(?:(\\w*):)?(\\w+)(?:@(\\w+))?"; //(\w*)?:(\w+)(@\w+)?

    //*****
//    переделать!!!!!!!!!!
    private Pattern pattern;

    public UserParser() {
        this.pattern = Pattern.compile(userRegExPattern);
    }


   //Должен ли метод возвращать НУЛ или лучше кидать эксепшн?
    public User parse(String userStr) {
//nickname:username@password
        Matcher matcher;
        User user = null;

        if (validateUserString(userStr)) {
            System.out.println("\nпарсим " + userStr);
            matcher = pattern.matcher(userStr);

            if ((matcher.find())) {
                System.out.print("nickname = ");
                System.out.println(matcher.group(1));

                System.out.print("username = ");
                System.out.println(matcher.group(2));

                System.out.print("password = ");
                System.out.println(matcher.group(3));

                System.out.println("----------------------");

                String username = matcher.group(2);
                String nickname = matcher.group(1) == null ? username : matcher.group(1);
                String password = matcher.group(3);

                user = new User(username,nickname,password);

            }
        } else {
            System.out.println(userStr + " - строка не парсится!");
            System.out.println("----------------------");
        }
//        User user = new User();

        return user;
    }

    //    Изменил имя метода (в задании оба метода имеют разную сигнатуру).
    //    Возможно стоило изменить входящий параметр на массив строк.
    public List<User> parseList(String usersString) {

        List <User> userList= new ArrayList<User>();

        List<String> userStrList = getUserStringsList(usersString);

        for (String s : userStrList) {
            userList.add(parse(s));
        }

        return userList;
    }

//    ---------------------------------------------------------
//    нужно ли вообще в отдельный метод     выносить????????

    //    private static List<String> getUserStringsList(String usersStr) {
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

        return userStr.matches(userRegExPattern);
    }

    //***************************************************************************************
//    public static void main(String[] args) {
////        String text = "programmer:vasia@123, " +
////                "programmer:vasia,   " +
////                "vasia@1234," +
////                "vasia:@trulala";
//
//        String text = ",,programmer:vasia@123, ," +
//                "programmer:vasia,   " +
//                "vasia@1234,," +
//                "vasia:@trulala,";
//
//        System.out.println(text);
//        System.out.println("--------------------");
//        for (String str : text.split(",")) {
//            System.out.println(str);
//        }
//        System.out.println("--------------------");
//
//        for (String str : getUserStringsList(text)) {
//            System.out.println(str);
//        }
//    }
}
