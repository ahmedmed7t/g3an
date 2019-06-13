package totchi.g3an.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tech on 3/7/2018.
 */

public class Validator {
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean valid_email(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,})$";
        pattern = Pattern.compile(ePattern, Pattern.CASE_INSENSITIVE);
        if (email != null) {
            matcher = pattern.matcher(email);
            return matcher.matches();
        } else
            return false;
    }

    public static boolean valid_password(String pass) {
        if (pass != null && pass.length() >= 6) {
            return true;
        } else return false;
    }

    public static boolean valid_name(String name) {
        if (name.length() < 3)
            return false;
        else
            return true;
    }

    public static boolean valid_date(String date) {
        if (date.length() != 0)
            return true;
        else
            return false;
    }

    public static boolean valid_gender(String gender) {
        if (gender != null)
            return true;
        else return false;
    }

    public static boolean valid_phone(String cashNum) {
        if (cashNum != null && cashNum.length() != 0)
            if (TextUtils.isDigitsOnly(cashNum))
                return true;
            else
                return false;
        else
            return false;
    }
}
