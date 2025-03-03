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

    public static void getAllSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int len = 1; i + len <= str.length(); len++) {
                System.out.println(str.substring(i, i + len));
            }
        }
    }

    public static void getAllPalindromicSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int len = 1; i + len <= str.length(); len++) {
                String s = str.substring(i, i + len);
                if (isPalindrome(s))
                    System.out.println(s);
            }
        }
    }

}