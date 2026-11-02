import java.util.Random;

public class main {
    
    public static void main(String[] args) throws Exception{

        //These are all fake names I came up with
        student s1 = new student("Jon Jilliams", "2027", 3.1, 20199225);
        student s2 = new student("Won Williams", "2030", 3.8, 20188310);
        student s3 = new student("Amanda Jenkins", "2027", 4.0, 20189301);
        student s4 = new student("Tina Fellina", "2029", 2.4, 20155118);
        student s5 = new student("Lebron Musk", "2027", 3.5, 20177811);

        s1.honors();
        s2.honors();
        s3.honors();
        s4.honors();
        s5.honors();

        Random r = new Random();


        //Made use of the random module to get an ID for use.
        int randomID = r.nextInt(99999999);
        System.out.println(randomID + " is the winning ID for today!");
        s1.freeLunch(randomID);
        s2.freeLunch(randomID);
        s3.freeLunch(randomID);
        s4.freeLunch(randomID);
        s5.freeLunch(randomID);


    }

    //In this assignment I learned how to use Random in java.
    //It doesn't work quite the same as random in python and it took a second to understand the operations
    
}
