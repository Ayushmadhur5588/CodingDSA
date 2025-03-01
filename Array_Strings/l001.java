public class l001 {
    
    public static int max(int[] arr){
        int maxResult = -(int)1e9;

        for(int i = 0; i < arr.length; i++){
            maxResult = Math.max(maxResult, arr[i]);
        }

        return maxResult;
    }

    public static int min(int[] arr){
        int minRes = (int)1e9;

        for(int i = 0; i < arr.length; i++){
            minRes = Math.min(minRes, arr[i]);
        }

        return minRes;
    }

    public static int findFirstIdx(int[] arr, int val){
        int idx = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val){
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static int findLastIdx(int[] arr, int val){
        int idx = -1;
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == val){
                idx = i;
                break;
            }
        }
        return idx;
    }
  
    public static void reverseArr(int[] arr){
        int si = 0, ei = arr.length - 1;
        while(si < ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }
  
    public static void inverse(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[arr[i]] = i;
        }
    }
    public static void main(String[] args){
        int[] arr = {3,2,65,1,71,99,1};
        System.out.println(max(arr));
        System.out.println(min(arr));
        System.out.println(findFirstIdx(arr,1));
        System.out.println(findLastIdx(arr,1));
    }

    //reverse
    //span
    //
}
