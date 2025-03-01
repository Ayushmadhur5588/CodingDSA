import java.util.Scanner;

public class l002 {
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void display1(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int maximum(int[][] arr) {
        int maxEle = -(int) 1e9;
        for (int[] ar : arr)
            for (int e : ar)
                maxEle = Math.max(maxEle, e);
        return maxEle;
    }

    public static int minimum(int[][] arr) {
        int minEle = (int) 1e9;
        for (int[] ar : arr)
            for (int e : ar)
                minEle = Math.min(minEle, e);
        return minEle;
    }

    }