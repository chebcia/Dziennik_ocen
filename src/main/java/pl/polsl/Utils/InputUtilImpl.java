package pl.polsl.Utils;
import pl.polsl.Interfaces.InputUtil;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import pl.polsl.exceptions.DialogExitException;

public class InputUtilImpl implements InputUtil {

    
     /**
     * The method displays the given message and then reads the string input
     * try to get a practical parsed result, except can retry
     *
     * @param <T> 
     * @param message message to be displayed on the console
     * @param typeParse parse a string to a given type
     * @return T
     */
    public <T> T readConsoleInput(String message, Function<String, T> typeParse) {
        System.out.println(message); // print message
        Scanner sc = new Scanner(System.in);   
        String rawInput = sc.nextLine();   // get line 
        try {
            return typeParse.apply(rawInput);
        } catch (Exception ex) {
            System.out.println("Podano złą wartość");
            return readConsoleInput(message, typeParse); //recursion 
        }
    }

    /**
     * The method read from console what user writes
     * @param message message 
     * @param choices user choice
     * @return
     * @throws DialogExitException
     */
    public int readConsoleSelect(String message, List<String> choices) throws DialogExitException {
        int choiceIndex = 1; // 1 because for loop start in 0 
        System.out.println("0: Powrót do menu głównego");
        for (String choice : choices) {
            System.out.println(choiceIndex++ + ": " + choice);
        }
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String rawInput = sc.next();
        if(rawInput.equals("0")) {
            throw new DialogExitException();
        }
        try {
            int result = Integer.parseInt(rawInput); // return int
            if(result > choices.size()) {
                throw new Exception("");
            }
            return --result;
        } catch (Exception ex) {
            System.out.println("Podano złą wartość");
            return readConsoleSelect(message, choices);
        }
    }

 
}
