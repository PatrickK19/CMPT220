import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


//the goal of this program is to create an unadjusted trial balance.
public class TrialBalance {

    //
    //Global variables
    //

    //To better accomplish the pairing of account names with their type and number, I did some research on the Map object.

    //This map objects maps account names to their location on the balance sheet, as well as if they are contra/temporary accounts
    public static Map<String, String> accounts = new HashMap<>();

    //This map marks the balances of accounts
    public static Map<String, Double> accountsBalance = new HashMap<>();

    //collects all inputs asked from user
    public static Scanner sc = new Scanner(System.in);

    //
    //Main
    //

    public static void main(String[] args){


        // Find length of the accounting period
        System.out.print("Enter length of period (Month or Year): ");
        String period = sc.next();

        // Collect date of period end
        System.out.println("Enter date of period end in MM/DD/YYYY format: ");
        String balanceDate = sc.next();

        // Collect name of company.
        System.out.println("Enter company name: ");
        String company = sc.next();


        //If this is the first accounting period, there will be no accounts with a balance.
        //If it is not the first accounting period, there will be, and startBalance will collect them.
        System.out.print("Is this the company's first accounting period? (y/n): ");
        if (sc.next().equals("n")){
            startBalance();
        }

        //Creates new list containing all journal entries entered.
        List<String[]> Journal = getJournalEntries();
        
        //Loops across every entry in the journal sequentially to add or subtract from each balance.
        for(String[] entry: Journal){
            
            //when i=1, we are processing debits; when i=2, we are processing credits
            for(int i=1; i<3; i++){

                //scan first number in the string to get number of accounts being altered
                Scanner lineScanner = new Scanner(entry[i]);
                //q is the number of accounts to be scanned.
                int q = lineScanner.nextInt();
                lineScanner.close();

                //debug
                //System.out.println("Number of rows: " + q);

                //c is a counter that cycles through each character in 
                int c = 0;

                //goes to next line
                while(entry[i].charAt(c) != '\n'){
                    c += 1;
                }
                
                //gets account and value over each line
                for(int j=0; j<q; j++){

                    //add one to get off '\n' character
                    c += 1;

                    String acct = "";
                    String value = "";

                    //Adds characters to acct until a space is reached.
                    while(entry[i].charAt(c) != ' '){
                        acct += entry[i].charAt(c);
                        c += 1;
                    }
                    
                    //debug
                    //System.out.println("Account: " + acct);

                    //add one to get off ' ' character
                    c += 1;

                    //Adds characters to value until newline is reached
                    while(entry[i].charAt(c) != '\n'){
                        value += entry[i].charAt(c);
                        c += 1;
                    }
                    //convert value to a Double named "valueDouble"
                    Double valueDouble = Double.valueOf(value);

                    //debug
                    System.out.println("Number: " + valueDouble);

                    //if account normal balance equals the action in transaction, add it tp total.
                    //if account normal balance is opposite to the action in transaction, subtract it from total.
                    if (accounts.get(acct).equals("dr") && i == 1){
                        accountsBalance.put(acct, (accountsBalance.get(acct) + valueDouble));
                    } else if (accounts.get(acct).equals("dr") && i == 2){
                        accountsBalance.put(acct, (accountsBalance.get(acct) - valueDouble));
                    } else if (accounts.get(acct).equals("cr") && i == 1){
                        accountsBalance.put(acct, (accountsBalance.get(acct) - valueDouble));
                    } else if (accounts.get(acct).equals("cr") && i == 2){
                        accountsBalance.put(acct, (accountsBalance.get(acct) + valueDouble));
                    }
                }  
            }
        }
        

        //debug
        //System.out.println(accounts);
        //System.out.println(accountsBalance);

        // accountsArr will be an array sorted with accounts that are debits, then credits.
        // It's not 100% accurate to what a trial balance looks like but it's close enough for the purposes of this assignment.
        String[] accountsArr = new String[accounts.size()];

        // counter is used to iterate through accountsArray and set values in the correct order.
        // Because the size of accountsArr was chosen to be the number of keys in accounts, 
        // there is no risk of counter calling a value outside the array.
        int counter = 0;

        // Find all accounts with type dr
        for (Map.Entry<String,String> account: accounts.entrySet()){
            String type = account.getValue();
            if (type.equals("dr")){
                accountsArr[counter] = account.getKey();
                counter += 1;
            }
        }  
        // Find all accounts with type cr
        for (Map.Entry<String,String> account: accounts.entrySet()){
            String type = account.getValue();
            if (type.equals("cr")){
                accountsArr[counter] = account.getKey();
                counter += 1;
            }
        }  



        //Create unadjusted trial balance
        //Generally numbers are supposed to be normalized to a column, with debits in one column and credits in another.
        //I didn't normalize the placement of bc i figure that's a little above my paygrade. I could totally figure it out though. Instead I just made a really large space.
        System.out.println(company);
        System.out.println("Unadjusted Trial Balance");
        System.out.println("For the " + period + " ended " + balanceDate);
        for (String account: accountsArr){
            if (accounts.get(account).equals("dr")){
                System.out.println(account + "   " + accountsBalance.get(account));
            } else{
                System.out.println(account + "                  " + accountsBalance.get(account));
            }
        }
    }

    //
    // Other Functions
    //

    //Asks for all journal entries for the beginning of the period.
    private static void startBalance(){
        

        

        System.out.println("Enter account balances from previous accounting period.");

        while (true){
            System.out.print("Enter account name. If account contains multiple words, separate with _ instead of space: ");
            String account = sc.next();

            System.out.print("Enter value of account in dollars: ");
            Double value = sc.nextDouble();
            System.out.print("Enter normal balance of account, debit(dr) or credit(cr): ");
            String type = sc.next();

            accounts.put(account, type);
            accountsBalance.put(account, value);

            System.out.print("Continue? (y/n): ");
            if (sc.next().equals("n")){
                return;
            }
        }
    }

    //Asks for all journal entries.
    private static List<String[]> getJournalEntries(){

        List<String[]> Transactions = new ArrayList<String[]>();
        
        while(true){

            //Add date, debits, and credits
            System.err.print("Add date of transaction in MM/DD/YYYY format: ");
            String dateOfTransaction = sc.next();
            String debits = collectDebits();
            String credits = collectCredits();

            //To make sure transaction was recorded correctly,
            // system prints out details and verifies correctness
            System.out.println(dateOfTransaction);
            System.out.println(debits);
            System.out.println(credits);
            System.err.print("Does this look correct? (y/n): ");
            
            //if y, record in Transactions and finish loop
            //If n, restart loop
            if (sc.next().equals("y")){
                Transactions.add(new String[]{dateOfTransaction,debits,credits});
            } else{
                continue;
            }
            
            //asks for another journal entry. if n, finish loop
            System.err.print("Add another journal entry? (y/n): ");
            if (sc.next().equals("n")){
                break;
            }

        }
        return Transactions;
    }

    //Asks for all items being debited in a transaction
    private static String collectDebits(){
        
        
        String debitString = "DEBITS";

        
        while(true){
            
            System.out.print("Write down item being debited.\nIf account contains multiple words, separate with _ instead of space: ");
            String accountDebited = sc.next();
  
            
            System.out.print("Type amount being debited to account: ");
            Double accountDebitedAmount = sc.nextDouble();
            String amountDebited = accountDebitedAmount.toString();

            //If accountDebited is not a key in accounts, ask user what type of transaction it is
            if (!accounts.containsKey(accountDebited)){
                System.out.print("New account detected.\nPlease indicate whether account has a normal debit (dr) or credit (cr) balance: ");

                accounts.put(accountDebited, sc.next());
                accountsBalance.put(accountDebited, (double)0);
            }
            debitString += "\n" + accountDebited + " " + amountDebited;


            //system asks to add another debit to transaction
            //If no debit necessary, break loop
            System.out.print("Add another debit? (y/n): ");
            if (sc.next().equals("n")){
                break;
            }

            
        }

        //computational stuff. counts number of accounts listed that are debited by the number of line breaks in the string
        Integer lines = countCharacter(debitString, '\n');
        System.out.println(debitString);
        return lines + " " + debitString + "\n";  
        
        //ex what debitString may look like:

            // 3 DEBITS\n
            // ACCT1 VALUE\n
            // ACC2 VALUE\n
            // ACC3 VALUE\n
    }

    //Asks for all items being credited in a transaction
    private static String collectCredits(){

 
        String creditString = "CREDITS";


        while(true){
            System.out.print("Write down item being credited.\nIf account contains multiple words, separate with _ instead of space: ");
            String accountCredited = sc.next();

            
            System.out.print("Type amount being credited to account: ");
            Double accountCreditedAmount = sc.nextDouble();
            String valueCredited = accountCreditedAmount.toString();

            //House
            if (!accounts.containsKey(accountCredited)){
                System.out.print("New account detected.\nPlease indicate whether account has a normal debit (dr) or credit(cr) balance: ");

                accounts.put(accountCredited, sc.next());
                accountsBalance.put(accountCredited, (double)0);
            }
            creditString += "\n" + accountCredited + " " + valueCredited;

            //system asks to add another credit to transaction
            //If no credit necessary, break loop
            System.out.print("Add another credit? (y/n): ");
            if (sc.next().equals("n")){
                break;
            }

            

        }
        //computational stuff. counts number of accounts listed that are credited by the number of line breaks in the string
        Integer lines = countCharacter(creditString, '\n');
        System.out.println(creditString);

        //new linebreak is added at the end of the string
        return lines + " " + creditString + "\n";

        //ex what debitString may look like:

        // 2 CREDITS\n
        // ACCT1 VALUE\n
        // ACC2 VALUE\n

    }

    //Counts the number of times a particular character appears in a string
    private static Integer countCharacter(String s, char c){
        Integer count = 0;

        for(int i=0; i< s.length(); i++){
            if (s.charAt(i) == c){
                count += 1;
            }
        }
        return count;
    }    
}
