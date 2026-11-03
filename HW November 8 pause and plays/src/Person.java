public class Person {
    String name;
    byte age;

    public Person(String n, byte a){
        name = n;
        age = a;
    }

    public void sayHi(){
        System.out.println(this.name + " says hi!");
    }
    
}
