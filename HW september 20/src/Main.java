//always start with importing our scanner so we can use it!
import java.util.Scanner;



/* our first practice file!
* create a 3 question quiz game (lots of if/else likely)
* requirements: keep track of the user's score, has to have at least 3 questions, use if/else
* can be any topic you pick :) feel free to pick some obscure or niche topics!
* good luck!
* */
public class Main {
    public static void main(String[] args) {

        Scanner answer = new Scanner(System.in);

        String q1 = "What is 2 times 2?";
        String q2 = "How many legs does a spider have?";
        String q3 = "What is the approximate diameter of earth in kilometers?";

        
        byte answersCorrect = 0;

        System.out.println(q1);
        int a1 = answer.nextInt();

        System.out.println(q2);
        int a2 = answer.nextInt();

        System.out.println(q3);
        int a3 = answer.nextInt();

        if (a1 == 4) {
            answersCorrect += 1;
        }

        if (a2 == 8) {
            answersCorrect += 1;
        }

        if (12000 <= a3 && a3 <= 13000){
            answersCorrect += 1;
        }

        if (answersCorrect == 0) {
            System.out.println("ur bad at quizzes");
        } else if (answersCorrect == 3) {
            System.out.println("You're so good!");
        } else{
            System.out.println("You got " + answersCorrect + " answers correct!");
        }


        answer.close();


    }
}


