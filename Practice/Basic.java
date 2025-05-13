public class Basic {
    public static void main(String[] args) {
        int[] arr = { 8, 3, 1, 6, 0 };
        // bubbleSort(arr);
        selectionSort(arr);
    }

    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {

        /*
         * Time Complexity:
         * Worst Case: O(n²) (jab array reverse sorted ho, har element ko compare aur
         * swap karna padta hai).
         * Best Case: O(n) (jab array pehle se sorted ho, sirf ek pass mein comparisons,
         * no swaps).
         * Average Case: O(n²) (random array ke liye).
         * Space Complexity:
         * 
         * O(1) (sirf ek temp variable use hota hai swapping ke liye, no extra space).
         */

        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            for (int item : arr) {
                System.out.print(item);
            }
            System.out.println();
        }
        for (int item : arr) {
            System.out.print(item);
        }
    }

    public static void selectionSort(int[] arr) {
        /*
         * Selection Sort Time Complexity (short mein):
         * 
         * Worst Case: O(n²) (har element ko baki sab se compare karna padta hai,
         * max/min dhundne ke liye).
         * Best Case: O(n²) (sorted array mein bhi poora comparison loop chalta hai, no
         * shortcut).
         * Average Case: O(n²) (random array ke liye bhi same).
         * Space Complexity: O(1) (sirf ek temp variable for swapping, no extra space).
         */

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        display(arr);
    }
}
