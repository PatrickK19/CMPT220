public class Car {
    String owner;
    String model;
    int speed;

    public Car(String o, String m, int s){
        owner = o;
        model = m;
        speed = s;
    }

    void race(Car c2){
        if (speed > c2.speed){
            System.out.println(owner + "'s " + model + " is faster than " + c2.owner + "'s " + c2.model);
        } else if (c2.speed > speed){
            System.out.println(c2.owner + "'s " + c2.model + " is faster than " + owner + "'s " + model);
        } else{
            System.out.println("It's a tie!");
        }
    }
    
}
