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

}