public class l002{

    public static void main(String[] args){
      int []arr = {2,1,1 ,1,1};
      //int res = maxOfArray(arr, 0);
      //System.out.println(res);
     // boolean res = findArray(arr, 2, 0);
      //System.out.println(res);
      int res = findLastIndex(arr, 1 , 0, 0);
      System.out.println(res);

    }
    
    public static int maxOfArray(int []arr, int i){
    
    if(i == arr.length){
        return -(int)1e9;
    }

    int res =  maxOfArray(arr, i+1);
    return Math.max(res,arr[i]);

    

    }

    public static boolean findArray(int[] arr, int data, int idx){

        if(idx == arr.length){
            return false;
        }

        if(arr[idx] == data){
            return true;
        }

        return findArray(arr, data, idx + 1);


    }

    public static int findLastIndex(int[] arr, int data, int idx, int lastIdx){

        if(idx == arr.length){
            return lastIdx;
        }

        if(arr[idx] == data){
            lastIdx = idx;
        }

        return findLastIndex(arr, data, idx + 1, lastIdx);


    }
   
    public static int[] findAllIndices(int[] arr, int size, int idx, int data){
        
        if(idx == arr.length){
            int[] res = new int[size];
            return res;
        }

        if(arr[i] == data){
            size++;
        }
       int[] ans = findAllIndices(arr, size, idx + 1, data);
        if(ans[i] == data){
            ans[size-1] = i;
        }
        return res;
        
    }

   public static ArrayList<String> getSS(String str) {
    if (str.length() == 0) {
      ArrayList<String> list = new ArrayList();
      list.add(" ");
      return list;
    } 

    char ch = str.charAt(0); // a
    String updated = str.substring(1); // abc -> bc
    ArrayList<String> result = getSS(updated);

    ArrayList<String> ff = new ArrayList(result);

    for (int i = 0; i < result.size(); i++) {

      ff.add(ch + result.get(i));
    }
    return ff;
  }


   public static ArrayList<String> getKPC(String str, String[] arr){

    if(str.length() == 0){
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

      char ch = str.charAt(0); // 5
      int num = ch - '0';  // 5 , 7 , 3
     String ros = str.substring(1); // 73, 
     ArrayList<String> result =  getKPC(ros, arr);

      String keyCombination = arr[num];  // mno
      ArrayList<String> finalResult = new ArrayList();

      for(int i = 0; i < keyCombination.length(); i++){
          char cha = keyCombination.charAt(i); // g , h , i
      for(String val : result){
          finalResult.add(cha + val); 
      }

      }

      return finalResult;

  }


}