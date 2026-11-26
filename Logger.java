import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Logger{

    private List<Log> logs = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    //A Logger needs to add Objects
    //Delete Objects
    //List all Objects
    //Also contains the CLI here


    public void addLog(String mediaType, String contentName){
        Log log = new Log(mediaType, contentName);
        logs.add(log);
        System.out.println(log);
    }

    public boolean checkLogsNonEmpty(List<Log> logs){
        if (logs.size() == 0){
            System.out.println("No logs available");
            return false;
        }
        return true;
    }

    public void showLogs(List<Log> logs){
        
        checkLogsNonEmpty(logs);

        for (int i = 0;i < logs.size(); i++){
            int enumerator = i + 1;
            System.out.println(enumerator + ") " + logs.get(i));
        }
    }

    public void deleteLogs(List<Log> logs){
        if (checkLogsNonEmpty(logs) == false){
            return;
        }
        showLogs(logs);

        System.out.println("Select a log to remove");

        try{
            while(true){
                int numberSelection = scanner.nextInt();

                if (numberSelection <= 0 || numberSelection > logs.size()){
                    System.out.println("Please select a number within range.");
                    continue;
                }
                logs.remove(numberSelection - 1);
                System.out.println("Deleted log number: " + numberSelection);
                return;

            }
        } catch (InputMismatchException e){
            System.out.println("Needs to be an integer value.");
        }
    }

    public void welcomeGreeting(){
        System.out.println("Welcome");
        System.out.println("1. Add\n2. Delete\n3. Display\n4. Menu\n5. Exit");
    }
    
    public void displayMenu(){
        try {
            while (true){
                
                int selection = scanner.nextInt();

                if (selection < 1 || selection > 5){
                    System.out.println("invalid input");
                    continue;
                }

                if (selection == 1){
                    scanner.nextLine();
                    System.out.println("Enter a media format");
                    String mediaType = scanner.nextLine();
                    System.out.println("Enter the content name");
                    String contentName = scanner.nextLine();
                    addLog(mediaType, contentName);
                    continue;
                } else if (selection == 2){
                    deleteLogs(logs);
                    continue;

                } else if (selection == 3){
                    showLogs(logs);
                    continue;
                } else if  (selection == 4){
                    welcomeGreeting();
                    continue;
                } else {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
            }
        } catch (InputMismatchException e){
                System.out.println("Input has to be an integer!");
            }

        }
}
