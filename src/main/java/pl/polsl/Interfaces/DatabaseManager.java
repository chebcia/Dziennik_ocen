package pl.polsl.Interfaces;

import pl.polsl.exceptions.ClazzNameException;
import pl.polsl.model.Clazz;
import pl.polsl.model.Marks;
import pl.polsl.model.Subject;

public interface DatabaseManager {

    /**
     *
     * @param clazz
     * @return
     * @throws ClazzNameException
     */
    String addClazz(Clazz clazz) throws ClazzNameException;

    /**
     *
     * @param subject
     * @return
     */
    String addSubject(Subject subject);

    /**
     *
     * @param mark
     * @return
     */
    String addGrade(Marks mark);

    /**
     *
     * @return
     */
    String generateId();

}
