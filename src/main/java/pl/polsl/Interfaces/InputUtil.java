package pl.polsl.Interfaces;

import pl.polsl.exceptions.DialogExitException;

import java.util.List;
import java.util.function.Function;

public interface InputUtil {

    /**
     *
     * @param <T>
     * @param message
     * @param typeParse
     * @return
     */
    <T> T readConsoleInput(String message, Function<String, T> typeParse);

    /**
     *
     * @param message
     * @param choices
     * @return
     * @throws DialogExitException
     */
    int readConsoleSelect(String message, List<String> choices) throws DialogExitException;
}
