public class Book {
    String title;
    String author;
    String genre;
    public Book(String t, String a, String g){
        title = t;
        author = a;
        genre = g;
    }
    public void checkIfGivingTree(){
        if (this.title.equals("The Giving Tree")){
            System.out.println("Gosh Shel Silverstein is so ugly in this book!");
        }
        else{
            System.out.println("Nice Book!");
        }
    }
}
