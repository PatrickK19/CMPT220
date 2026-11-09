public class Main {
    public static void main(String[] args) {

        //create a generic enemy and call its functions
        Enemy jeff = new Enemy(2, 3);
        jeff.attack();
        //create a fire and an ice wizard and call all functions
        Wizard Firey = new Wizard(1, 9, "fire");
        Wizard Icy = new Wizard(1, 9, "fire");
        Firey.damageType();
        Icy.damageType();
        //create a goblin and call its functions
        Goblin Thanos = new Goblin(3, 5);
        Thanos.attack();

    }
}