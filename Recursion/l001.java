public class l001{
    public static void main(String[] args){
       // printIncreasing(5);
       //int res = factorial(5);
      // System.out.println(res);
       int res = power(2,4);
       System.out.println(res);
    }

    public static void printDecreasing(int n){
        if(n == 0)return;
            System.out.println(n);
            printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n == 0)return;
            
            printIncreasing(n-1);
            System.out.println(n);
    }

    public static int factorial(int n){
        if(n == 0) return 1;
        int fact = n * factorial(n-1);
        return fact;
    }

    public static int power(int x, int n){
        if(n == 0) return 1;
        int res = x * power(x, n-1);
        return res;
    }

    
}