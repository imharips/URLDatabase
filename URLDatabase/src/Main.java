import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
     static Scanner scanner=new Scanner(System.in);
    static String command=" ";
     static void run() throws JsonProcessingException {  // Starting point for the program
         String input;
         while(!command.equals("exit")){
            // choose the option storing, getting url,getting list of url,exiting
            System.out.println("1.Store\n2.Get\n3.Count\n4.List\n5.Exit\n");
            System.out.print("Enter the command : ");
            command =scanner.nextLine().toLowerCase();

            switch(command){
                case "store":
                    System.out.print("Enter the URL : ");
                    input=scanner.nextLine();
                    System.out.println();
                    if(URLDB.isPresent(input)){
                        System.out.println("Duplicate entries are not allowed");
                    }
                    else {
                        URLDB.storeUrl(input);
                    }
                    break;

                case "get":
                    System.out.print("Enter the URL of the unique ID : ");
                    input=scanner.next();
                    scanner.nextLine();
                    System.out.println();
                    if (URLDB.isPresent(input)) {            //searching for entry of given url if present -print

                        System.out.println("Unique short key of the entered URL "+input+" : "+URLDB.get(input));
                    }

                    else {                            // else ask to store or not

                        System.out.print("There is no URL like "+input+" in database\n\nWant to add this to database? Yes or No : ");
                        if(scanner.nextLine().equalsIgnoreCase("yes")){
                            //System.out.println();
                            URLDB.storeUrl(input);

                        }
                        else if(scanner.nextLine().equalsIgnoreCase("no")){
                            return;
                        }
                    }
                    break;

                case "count":
                    System.out.print("Enter the URL of the latest usages : ");
                    input=scanner.nextLine();
                    if (URLDB.isPresent(input)) {   //if its present int db get the count
                        System.out.println("Latest usage of the URL "+input+" : "+URLDB.count(input));
                    }
                    else {                  // if not present ask to store or not
                        System.out.println("There is no URL like "+input+" in database\n\nWant to add this to database? Yes or No\n");
                        if(scanner.nextLine().equalsIgnoreCase("yes")){
                            URLDB.storeUrl(input);
                        }
                        else if(scanner.nextLine().equalsIgnoreCase("no")){
                            return;
                        }
                    }
                    break;

                case "list": //4. listing urls
                    for(String s:URLDB.listURL()){
                        System.out.println(s);
                    }
                    System.out.println();
                    break;

                case "exit":
                    System.out.println("exiting...");
                    return;

                default:
                    System.out.println("Invalid Command !!!");
            }
        }
    }


    public static void main(String[] args) throws JsonProcessingException {
        run();

    }
}