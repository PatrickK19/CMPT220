import java.util.Scanner;

public class Debug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How old are you?");

        // No person who has existed as of 2026 has ever lived over 127 years, so a byte is sufficient
        // Gotta save memory yk
        byte age = sc.nextByte();

        System.out.println("You are " + age + " years old.");

        // I closed my scanner because vsc was flagging it. 
        // Gotta save memory yk
        sc.close();


        // Spacing out tasks for clarity
        System.out.println("\n\n\n");

        int num1 = 10;
        int num2 = 37;
    
        System.out.println("The sum of 10 and 37 is " + num1 + num2);


        


        // What I learned is that you should close tasks such as scanners after you're done using them to save memory.
    

    }
}
