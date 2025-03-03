import java.util.ArrayList;

public class l003 {

    public static boolean isPalindrome(String str) {
        int si = 0, ei = str.length() - 1;
        while (si < ei) {
            if (str.charAt(si++) != str.charAt(ei--))
                return false;
        }

        return true;
    }

}