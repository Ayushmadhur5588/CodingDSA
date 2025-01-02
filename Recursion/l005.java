public class l005 {

    public static void permutationWithInfi_Sub(int[] arr, int target, int idx, String ans){
    if(target == 0 || idx == arr.length){
        if(target == 0){
        System.out.println(ans);
        }
        return;
    }
       
        if(target-arr[idx] >= 0){
        permutationWithInfi_Sub(arr, target - arr[idx], idx, ans + arr[idx]);
        }
        permutationWithInfi_Sub(arr, target, idx + 1, ans);
       
    }
}