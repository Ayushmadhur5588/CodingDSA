import java.util.LinkedList;

public class l003 {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }
        System.out.println();
    }

    public static int fib_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = fib_memo(n - 1, dp) + fib_memo(n - 2, dp);
        return dp[n] = ans;

    }

    public static int fib_DP(int N, int[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
        return dp[N];

    }

    public static int fibo_Opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }

    public static void fibo(int n) {
        int[] dp = new int[n + 1];
        // int res = fib_memo(n, dp);
        int res = fib_DP(n, dp);
        System.out.println(res);
        print(dp);
    }

    public static int board_memo(int n, int[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }
        if (dp[n] != 0)
            return dp[n];

        int ans = 0;

        for (int d = 1; d <= 6 && n - d >= 0; d++) {
            ans += board_memo(n - d, dp);
        }

        dp[n] = ans;

        return ans;
    }

    public static int board_DP(int n, int[] dp) {

        for (int i = 0; i <= n; i++) {

            if (n == 0) {
                dp[n] = 1;
                continue;
            }
            int ans = 0;
            for (int d = 1; d <= 6 && n - d >= 0; d++) {
                ans += dp[n - d];
            }

            dp[n] = ans;
        }
            return dp[n];
        
    }

    public static int board_Op(int n){
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(1);

        for(int i = 2; i <= n; i++){
            if(list.size() < 6){
                list.addLast(list.getLast() * 2);
            }else{
                list.addLast(list.getLast() * 2 - list.removeFirst());
            }
        }
        return list.getLast();
    }







    public static void board(int n) {
        int[] dp = new int[n + 1];
        System.out.println(board_memo(n, dp));
    }

    public static void main(String[] args) {
        // int[][] arr = {{1,2,3}, {4,5,6}};
        // print2D(arr);
        // fibo(5);
        board(10);
    }
}
