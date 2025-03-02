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

    public static boolean find(int[][] arr, int data) {
        for (int[] ar : arr)
            for (int e : ar)
                if (e == data)
                    return true;

        return false;
    }

    public static void waveTraversalLeftRight(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }

    public static void waveTraversalUpAndDown(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }

    public static void diagonalTraversal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int gap = 0; gap < m; gap++) {
            for (int i = 0, j = gap; i < n && j < m; i++, j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void rotate90(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
 
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

       // reverse of columns
        int j1 = 0, j2 = m - 1;
        while(j1 < j2){
            for(int i = 0;i < n;i++){
                int temp = arr[i][j1];
                arr[i][j1] = arr[i][j2];
                arr[i][j2] = temp;
            }

            j1++;
            j2--;
        }
    }


    }