

public class Main
 {
    public static void main(String[] args) throws Exception {
        int[] myArray = {10,3,295,38,20,3,4,267,2445,10,5566,87,93,17,10,2,87,267,3176,3,82};
        
        //newArray stores the occurances of repeated elements
        // The setup of this presents the issue that if the default element of newArray is repeated in myArray, it will not be checked even if it does repeat.
        // I couldn't find a way around this so I just set the default value to a large number as shown below.
        int[] newArray = new int[myArray.length];

        //Thought I would need this because I thought the questions were sequential. 
        // I didn't realize they were all part of 1 assignment.
        int[] newArrayCount = new int[myArray.length];

        //assigned to the number of times a number appears within an array.
        int count = 0;
        
        // To minimize the possibility of overlaps in a general array, 
        // I set all values in newArray to the negative 31 bit integer limit according to google.
        for (int i = 0; i < myArray.length; i++){
            newArray[i] = -2147483648;
        }



        for (int i=0; i < myArray.length; i++) {

            // If myArray[i] is already in newArray, we already know it repeats, so it is pointless to count it again.
            // So only the first instance of a repeated element is printed out
            if (in(newArray, myArray[i])){
                continue;
            }

            //Count the number of times an element appears in an array
            count = countElement(myArray, myArray[i]);

            
            //Checks if a number was counted multiple times
            if (count > 1){
                
                newArray[i] = myArray[i];
                newArrayCount[i] = count;

                System.out.println(myArray[i] + " appears " + count + " times");
            }
        }
    }
    
    // I made functions that neatened the code a little

    //Checks if a number is in a particular array.
    private static boolean in(int[] Arr, int value){

        for (int obj: Arr){
            if (obj == value){
                return true;
            }
        }
        return false;



    }


    //Counts how many times a particular element in an array occurs in said array.
    private static int countElement(int[] Arr, int value){
        int count = 0;
        for (int obj: Arr){
            if (obj == value){
                count += 1;
            }
        }

        return count;

    }
}

//What I learned

//I learned how to make a function which counts the number of times a particular number appears in an array, 
// and one which checks whether an item appears more than once in an array.

//I also learned how the default value for elements in an int array is technically 0, 
// and since I have to set it to an integer value the only real solution is to pick a large number that is unlikely to appear in the use case.