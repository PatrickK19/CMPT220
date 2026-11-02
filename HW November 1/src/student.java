public class student {
    String name;
    String year;
    double gpa;
    int id;
    public student(String n, String y, double g, int i){
        name = n;
        year = y;
        gpa = g;
        id = i;
    }
    
    //new method

    public void honors(){
        if(gpa > 3.6){
            System.out.println(name + " is an honors student");
        } else{
            System.out.println(name + " is not an honors student");


        }
    }
    


    //new method
    public void freeLunch(int winningID){
        if (id == winningID){
            System.out.println(name + " gets free lunch.");
        } else{
            System.out.println(name + " does not get free lunch.");
        }
    }

}
