package com.hillel.artemjev.userparse;

public class Main {

    public static void main(String[] args) {
//        String text = "programmer:vasia@123," +
//                "programmer:vasia," +
//                "vasia@1234," +
//                "vasia:@trulala";

//        String text = "programmer:vasia@123, " +
//                "programmer:vasia,   " +
//                "vasia@1234," +
//                "vasia:@trulala";

        String text = ",,programmer:vasia@123, ," +
                "programmer:vasia,   " +
                "vasia@1234,," +
                "vasia," +
                "vasia:@trulala,";

        System.out.println(text);
        System.out.println("--------------------");
        for (String str : text.split(",")) {
            System.out.println(str);
        }
        System.out.println("--------------------");

        UserParser userParser = new UserParser();


        System.out.println("--------------------");

        System.out.println("получили список пользователей:");

        for (User u : userParser.parseList(text)) {
            System.out.println(u);

        }

//        userParser.parseList(text);
    }
}
