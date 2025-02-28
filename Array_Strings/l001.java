public class l001 {
    
    public static int max(int[] arr){
        int maxResult = -(int)1e9;

        for(int i = 0; i < arr.length; i++){
            maxResult = Math.max(maxResult, arr[i]);
        }

        return maxResult;
    }
    public static void main(String[] args){
        int[] arr = {3,2,65,71,99,1};
        System.out.println(max(arr));
    }
}
