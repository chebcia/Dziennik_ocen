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
     * @param args do not use the parameters in console
     */
    
    public static void main(String[] args) {
        
        Controller controller = new Controller(); // class controler
        UserDialog userDialog = new UserDialog(controller); // create object
        while (userDialog.actionPick()) { // user dialog
            controller.saveToFileXml();  //save to XML
        }
    }
}
