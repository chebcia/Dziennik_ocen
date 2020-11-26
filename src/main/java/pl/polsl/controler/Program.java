package pl.polsl.controler;
import pl.polsl.view.UserDialog;

/**
 * Program class - main method starts and controlls the application.
 *
 * @author Natalia Cheba
 * @version 1.0
 */

public class Program {
     /**
     * main method.Create controller, dialog with user and save to XML
     * @param args --help --database
     */
    
    public static void main(String[] args) {
       int i = 0 ;
       String nameOfDatabase = new String();
       for (String s: args) {
           
           if(s.startsWith("--help"))
               
           {System.out.println( "Usage: java -jar NataliaCheba-1.0-SNAPSHOT.jar [parameters]");
            System.out.println( " --help help"); 
            System.out.println( " --database databasename"); 
           }
           else if(s.startsWith("--database"))
           {
               nameOfDatabase = args[i+1];
               
           }
           i++;
        }
       
        Controller controller = new Controller(nameOfDatabase); // class controler
        UserDialog userDialog = new UserDialog(controller); // create object
        while (userDialog.actionPick()) { // user dialog
            controller.saveToFileXml();  //save to XML
        }
    }
}
