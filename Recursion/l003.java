public class l003 {
    public static void main(String[] args){
       String str = "aabcdeaaf";
       char ch = 'a';
       moveCharactertoEnd(str, "", 0, 0, ch);
    }

    public static void moveCharactertoEnd(String str, String ans, int idx, int count, char ch) {


        if (idx == str.length()) {
          while(count-- > 0){
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
    }