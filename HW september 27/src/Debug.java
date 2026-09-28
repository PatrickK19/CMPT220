import java.util.Scanner;

public class Debug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //P1: This one only prints 0-9, can you fix it so it prints 1-10? ok
        System.out.println("Problem 1");
        for (int i = 0; i <= 10; i++){
            System.out.println(i);
        }

        //P2: Ask the user for a number. Create a loop to find the factorial of it
        //(factorial = X!, X being the user input, Factorials are every digit before X multiplied together)
        System.out.println("Problem 2");
        System.out.println("Enter a number and I will tell you the factorial: ");

        int num = sc.nextInt();

        int prod = 1;
        //here's a hint
        for (int i = 1; i <= num; i++){
            prod *= i;
        }
        System.out.println(num + "! = " + prod);


        //P3: Ask the user for a number, and then add together every OTHER digit (starting from 1)
        System.out.println("Problem 3");
        System.out.println("Enter a number and I will tell you the sum of every other number: ");
        //No hint! what do you need to complete this task?
        
        // did need to look up how to make nextInt a string so I could single each digit out like so.
        String input = String.valueOf(sc.nextInt());

        int sum = 0;

        // look i don't know what to tell you, but it does what you asked. 
        // I thought that this function would cast characters as integers, but for whatever reason it does not.
        // I can only assume the + 48 factor is caused by the int x reading characters as ascii values, 
        // but I shifted them by -48 so the integer value equals the name of the character.
        for (int i = 1; i < input.length(); i += 2){
            sum += (input.charAt(i)-48);
        }
        System.out.println("The sum of every other digit is " + sum);




        //P4: Why does this loop never stop!
        //what can you do to break out of the loop after it prints once?
        System.out.println("Problem 4");
        boolean run = true;
        while (run == true){
            System.out.println("I printed once!");
            break;
        }

        //P5: Take a string from the user and print them the reverse!
        System.out.println("Problem 5");
        //hint

        String str_input = sc.next();

        String reverse = "";
        for (int i = str_input.length()-1; i >= 0; i--){
            reverse += str_input.charAt(i);
        }
        System.out.println(reverse);

    }
}
