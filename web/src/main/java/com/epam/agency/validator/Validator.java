package com.epam.agency.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator{
    private static final String REGEX_FOR_LOGIN = "^[a-zA-Z](.[a-zA-Z0-9_-]*)$";
    private static final String REGEX_FOR_PASSWORD = "\\w{6,}";

    public final static boolean isNull(Object... objects) {
        for (Object ob : objects) {
            if (ob == null) {
                return false;
            }
        }
        return true;
    }


    public final static boolean isEmptyString(String... strings) {
        for (String s : strings) {
            if (s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final static boolean matchLogin(String... strings) {
        Pattern pattern = Pattern.compile(REGEX_FOR_LOGIN);
        Matcher matcher;
        for (String s : strings) {
            matcher = pattern.matcher(s);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
    public final static boolean matchPassword(String... strings) {
        Pattern pattern = Pattern.compile(REGEX_FOR_PASSWORD);
        Matcher matcher;
        for (String s : strings) {
            matcher = pattern.matcher(s);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }

}
