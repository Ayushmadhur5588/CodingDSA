import java.util.ArrayList;

public class l003 {
    public static void main(String[] args) {
        String str = "aabcdeaaf";
        char ch = 'a';
        // moveCharactertoEnd(str, "", 0, 0, ch);
        // removeAllHi("hhiij", "", 0);

        //getPath(0, 0, 2, 2, "");
       ArrayList<String> result = getPath2(0, 0, 2, 2);
       for(String val : result){
        System.out.println(val);
       }
    }

    public static void moveCharactertoEnd(String str, String ans, int idx, int count, char ch) {

        if (idx == str.length()) {
            while (count-- > 0) {
                ans = ans + ch;
            }
            System.out.println(ans);
            return;
        }
        char ch1 = str.charAt(idx);

        if (ch1 != ch) {
            moveCharactertoEnd(str, ans + ch1, idx + 1, count, ch);
        } else {
            moveCharactertoEnd(str, ans, idx + 1, count + 1, ch);
        }

    }

    public static void removeAllHi(String str, String ans, int idx) {

        if (idx >= str.length() - 1) {
            if (idx == str.length() - 1) {
                ans = ans + str.charAt(str.length() - 1);
            }
            System.out.println(ans);
            return;

        }
        char prev = ans.length() > 0 ? (ans.charAt(ans.length() - 1)) : (' ');

        char ch = str.charAt(idx);
        char ch1 = str.charAt(idx + 1);

        if (ch == 'i' && prev == 'h') {
            ans = ans.substring(0, ans.length() - 1);
            removeAllHi(str, ans, idx + 1);
        } else if (ch == 'h' && ch1 == 'i') {
            removeAllHi(str, ans, idx + 2);
        } else {
            removeAllHi(str, ans + ch, idx + 1);
        }
    }

    public static void getPath(int sc, int sr, int dc, int dr, String ans) {

        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        if (sc + 1 <= dc) {
            getPath(sc + 1, sr, dc, dr, ans + "H");
        }
        if (sr + 1 <= dr) {
            getPath(sc, sr + 1, dc, dr, ans + "V");
        }
        if (sr + 1 <= dr && sc + 1 <= dc) {
            getPath(sc + 1, sr + 1, dc, dr, ans + "D");
        }

    }

    public static ArrayList<String> getPath2(int sc, int sr, int dc, int dr) {

        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> list = new ArrayList<>();
        if (sc + 1 <= dc) {
            ArrayList<String> res = getPath2(sc + 1, sr, dc, dr);
            for (String s : res) {
                list.add("H" + s);
            }
        }

        if (sr + 1 <= dr) {
            ArrayList<String> res = getPath2(sc, sr + 1, dc, dr);
            for (String s : res) {
                list.add("V" + s);
            }
        }

        if (sr + 1 <= dr && sc + 1 <= dc) {
            ArrayList<String> res = getPath2(sc + 1, sr + 1, dc, dr);
            for (String s : res) {
                list.add("D" + s);
            }
        }
        return list;

    }

}