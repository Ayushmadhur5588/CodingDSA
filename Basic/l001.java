import java.util.Scanner;

public class l001 {
    public static Scanner scn = new Scanner(System.in);

    public static long baseToDecimal(long n, long b) {
        long pow = 1, res = 0;
        while (n != 0) {
            long lastDigit = n % 10;
            n /= 10;

            res += lastDigit * pow;
            pow *= b;
        }

        return res;
    }

   
    public static void main(String[] args) {
        long n = scn.nextLong();
        long base1 = scn.nextLong();
        long base2 = scn.nextLong();

        long ans1 = baseToDecimal(n, base1);
    }
}