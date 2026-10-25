import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args){
        Map<String, Integer> test = new HashMap<>();

        test.put("Hair", 2);
        test.put("Pair", 3);
        test.put("Fair", -1);
        test.put("Lair", 111);
        test.put("Blair", 67);

        System.out.println(test);
        System.out.println(test.size());

        for (Map.Entry<String,Integer> account: test.entrySet()){
            String key = account.getKey();
            System.out.println(account);
            System.out.println(key);
            
        }


    }
}
