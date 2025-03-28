import java.util.Scanner;
public class l002{
    public static Scanner scn = new Scanner(System.in);

    public static int multiply(int a,int b){
        int c = a * b;
        return c;
    }
    
    public static int add(int a,int b){
        int c = a + b;
        return c;
    }
    
    public static int subtract(int a,int b){
        int c = b - a;
        return c;
    }
    
    public static int divide(int a,int b){
        int c = b / a;
        return c;
    }
    
    public static void printmessage(){
       System.out.println("see you soon!");
    }

    public static void gradingSystem(int marks){
        if(marks > 90){
            System.out.println("excellent");
        }else if(marks > 80){
            System.out.println("good");
        }else if(marks > 70){
            System.out.println("fair");
        }else if(marks > 60){
            System.out.println("meets expectations");
        }else{
            System.out.println("below par");
        }
    }


    public static void printNTime(int n){
        for(int i = 1; i <= n; i++){
            System.out.println("Hello!");
        }
    }

    public static void printTableOfN(int n){
        for(int i = 1;i <= 10;i++){
            System.out.println(n + " X " +  i + " = " + n * i);
        }
    } 

    public static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void primeNumbers(){
        int t = scn.nextInt();
        for(int i = 1; i <= t; i++){
            int n = scn.nextInt();
            
            if(isPrime()){
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }
        }
    }

    public static void primeTillN(int n,int m){
        for(int i = n; i <= m; i++){
            if(isPrime(i)) System.out.println(i);
        }
    }

    public static int gcd(int a,int b){
    
        int divisor = a;
        int dividend = b;
        
        while(dividend % divisor != 0){
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        
        return divisor;
    }

    public static int lcm(int a,int b,int g){
        return (a * (b / g));
    }

    public static int digits(int n){
        int count = 0;
        while(n != 0){
            count++;
            n /=10;
        }
        
        return count;
    } 

    public static int rotate(int n,int r){
        int len = digits(n);
        // r %= len;
        // if(r < 0) r += len;

        r = (r % len + len) % len;

        int mul = 1;
        int div = 1;
        
        for(int i=1;i<=len;i++){
            if(i <= r) div *= 10;
            else mul *= 10;
        }
        
        int a = n % div;
        int b = n / div;
        
        return a * mul + b;
    } 

    public static long baseToDecimal(long n,long b){
        long pow = 1,res = 0;
        while(n != 0){
            long lastDigit = n % 10;
            n /= 10;
            
            res += lastDigit * pow;
            pow *= b;
        }

        return res;
    }

    public static long anyBaseAdd(long n,long m,long b){
        long carry = 0, pow = 1, res = 0;
        while(n != 0 || m != 0 || carry != 0){
            long sum = 0;
            sum += carry + n % 10 + m % 10;
            n /= 10;
            m /= 10;

            int ld = sum % b;
            carry = sum / b;
            
            res += ld * pow;
            pow *= 10;
        }

        return res;
    }

    public static long anyBaseSub(long n,long m,long b){
        // m > n
        long borrow = 0, pow = 1, res = 0;
        while(n != 0 || m != 0){
            long sum = (m % 10 + borrow) - n % 10;
            n /= 10;
            m /= 10;

            if(sum < 0) {
                sum += b;
                borrow = -1;
            }else
               borrow = 0;

            res += sum * pow;
            pow *= 10;
        }

        return res;
    }
    

    public static long binaryAdd(long n,long m){
        long carry = 0, pow = 1, res = 0;
        while(n != 0 || m != 0 || carry != 0){
            long sum = 0;
            sum += carry + n % 10 + m % 10;
            n /= 10;
            m /= 10;

            int ld = sum % 2;
            carry = sum / 2;
            
            res += ld * pow;
            pow *= 10;
        }

        return res;
    }

    public static long decimalSub(long n,long m){
        // m > n
        long borrow = 0, pow = 1, res = 0;
        while(n != 0 || m != 0){
            long sum = (m % 10 + borrow) - n % 10;
            n /= 10;
            m /= 10;

            if(sum < 0) {
                sum += 10;
                borrow = -1;
            }else
               borrow = 0;

            res += sum * pow;
            pow *= 10;
        }

        return res;
    }

    public static long DecimalToBase(long n,long b){
        long pow = 1,res = 0;
        while(n != 0){
            long rem = n % b;
            n /= b;
            
            res += rem * pow;
            pow *= 10;
        }

        return res;
    }

}