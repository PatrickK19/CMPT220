/*
challenge file!
this one isn't too tough but it does require a little bit of writing and some googling
figure out how to take a string from the user
then print back out every individual letter one letter per line
I also am requiring a small write up: explain your discovery to me.
how did you figure out how to do this? can you translate your code into simple terms? 
you need to explain why you picked your for loop conditional and what's doing the work with the string
!!!!!!
Look into things like charAt- DO NOT NAME YOUR VARIABLE "REVERSED". If you do, automatic 0 points!!!!!!
!!!!!!!
if you're confused reach out!
 */

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String response = sc.nextLine();

        //I found two methods which I think are both useful in their own rights

        // This method involves using charAt function to call each character of a string individually
        // because indices are counted from 0 in java, the for loop conditional starts at 0 and ends at index n-1 (n is the length of the input)
        for (int i = 0; i < response.length(); i++){
            System.out.println(response.charAt(i));
        }

        System.out.println();
        System.out.println();

        // This method involves turning my input string into an array of individual characters and printing each element of the array
        // The for loop conditional looks at each element of the array from least index to greatest index.
        for (char ch: response.toCharArray()){
            System.out.println(ch);
        }
        



        sc.close();
    }
}

