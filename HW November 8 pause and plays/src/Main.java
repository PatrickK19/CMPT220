public class Main {
    public static void main(String[] args) throws Exception {

        Person bob = new Person("Bob", (byte)18);
        bob.sayHi();
        System.out.println();
        System.out.println();
        System.out.println();

        Book book1 = new Book("The Giving Tree", "Shel Silverstein", "Kids");
        Book book2 = new Book("The Magic Treehouse", "Mary Pope Osborne", "Thriller");

        book1.checkIfGivingTree();
        book2.checkIfGivingTree();

        Car c1 = new Car("Bob", "Civic", 67);
        Car c2 = new Car("Lebron", "Ferrari", 195);

        c1.race(c2);

    }

}
