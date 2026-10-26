/*
Referencing your homework from https://github.com/melissachodziutko/CMPT-220/blob/main/Assignment%203/Debug.java
Can you take problems 2, 3, and 5 and turn them into methods, and then call those methods in main?
Things that may trip you up while working on this:
1. the code works the same whether it's in a method or not, it just needs some minor variable adjustments probably
2. be wary of opening and closing brackets!! 
3. methods can't go inside methods!
4. methods go outside public static main, but inside public class main!
5. do you need to return the value? if so, make sure it isn't void

I give you two fully working method examples with and without parameters and called them for your reference :)
*/

import java.util.Scanner;
public class debug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your first number to be added");
        int firstInput = sc.nextInt();
        System.out.println("Enter your second number to be added");
        int secondInput = sc.nextInt();
        //remember this method is returning, so we need to print it out
        System.out.println(add(firstInput,secondInput));

        System.out.println("im going to print out the word Dog now.");
        printDog();


        System.out.println("take factorial");
        factorial(sc.nextInt());
        

        System.out.println("Enter int to do something to");
        idkwhat2callthis(sc.next());

        System.out.println("Enter word to reverse");
        reverse(sc.next());
        
    }

    public static void factorial(int x){
        int prod = 1;
        for (int i=1; i<=x; i++){
            prod *= i;
        }
        System.out.println(x + "! = " + prod);
    }

    public static void idkwhat2callthis(String input){
        int sum = 0;
        for (int i = 1; i < input.length(); i += 2){
            sum += (input.charAt(i)-48);
        }
        System.out.println("The sum of every other digit is " + sum);
    }

    public static void reverse(String str_input){
        String reverse = "";
        for (int i = str_input.length()-1; i >= 0; i--){
            reverse += str_input.charAt(i);
        }
        System.out.println(reverse);
    }



    public static int add(int zyx, int tuv){


        return(zyx + tuv);


    }

  
    public static void printDog(){
        System.out.println("Dog");
    }

  
}