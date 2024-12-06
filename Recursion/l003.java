public class l003 {
    public static void main(String[] args){
       String str = "aabcdeaaf";
       char ch = 'a';
      // moveCharactertoEnd(str, "", 0, 0, ch);
      // removeAllHi("hhiij", "", 0);

      getPath(0, 0, 2, 2, "");
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
    

    public static void removeAllHi(String str, String ans, int idx){
         
        if(idx >= str.length() - 1){
        if(idx == str.length() - 1){
            ans = ans + str.charAt(str.length() - 1);
        }
        System.out.println(ans);
        return;
       
    }  
    char prev = ans.length() > 0? (ans.charAt(ans.length()-1)) :  (' ');
    
        char ch = str.charAt(idx);
        char ch1 = str.charAt(idx + 1);

        if(ch == 'i' && prev == 'h'){
        ans = ans.substring(0,ans.length()-1);
        removeAllHi(str, ans, idx + 1);
    }
       else if(ch == 'h' && ch1 == 'i'){
           removeAllHi(str, ans, idx + 2);
        }else{
           removeAllHi(str, ans + ch, idx + 1);
        }
    }


    public static void getPath(int sc, int sr, int dc, int dr, String ans){
        
        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }

        if(sc + 1 <= dr){
        getPath(sc + 1, sr, dc, dr, ans + "H");
        }
        if(sr + 1 <= dr){
        getPath(sc, sr + 1, dc, dr, ans + "V");
        }
        if(sr + 1 <= dc && sc + 1 <= dc){
        getPath(sc + 1, sr + 1, dc, dr, ans + "D");
        }



    }

}