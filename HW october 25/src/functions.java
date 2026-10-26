import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class functions {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        Integer x = sc.nextInt();
        List<Integer> factors = factor(x);
        System.out.println("Factors of "+ x);
        for(Integer f: factors){
            System.out.println(f);
        }

        sc.close();
    }


    //I want to list a number's integer factors, so I did this. I loop through all integers between 1 and n inclusive and check if they are equiv to 0 mod n. then i add them to a list.
    public static List<Integer> factor(Integer n){
        List<Integer> output = new ArrayList<>();
        int q = n;
        for (int i=1; i<=n; i++){
            if(n%i == 0){
                output.add((Integer)i);
            }
        }
        
        return output;
    }
}
