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

}