import java.util.Arrays;

public class l002 {

    public static void print(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }

        System.out.println();
    }

    // 516
    // LPSS : longestPalindromicSubsequence
    public static int LPSS(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return dp[i][j] = (i == j) ? 1 : 0;
        }

        if (dp[i][j] != 0)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = LPSS(str, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(LPSS(str, i + 1, j, dp), LPSS(str, i, j - 1, dp));
    }

    public static int LPSS_DP(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;// LPSS(str, i + 1, j - 1, dp) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[I][J];
    }
}