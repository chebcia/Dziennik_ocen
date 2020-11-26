package pl.polsl.model;
import pl.polsl.Interfaces.DatabaseManager;
import pl.polsl.exceptions.ClazzNameException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Database is a class cointains importants parameters from other classes. 
 * It helps get value from various classes.
 * @author Natalia Cheba
 * @version 1.0
 */

public class Database implements Serializable, DatabaseManager {

    /*
    * subjects - list fo subjects
    */
    private List<Subject> subjects; //list of subjects
   /*
     * clazzes - list fo classes
    */
    private List<Clazz> clazzes; // list of classes
    /*
     * grades - list fo grades
    */
    private List<Marks> grades;  // list fo grades
    //CONSTRUCTORS
   
    /**
     *
     */
    public Database() {
    }

    /**
     *
     * @param subjects list of subjects
     * @param clazzes list of classes
     * @param grades list of grades 
     */
    public Database(List<Subject> subjects, List<Clazz> clazzes, List<Marks> grades) {
        this.subjects = subjects;
        this.clazzes = clazzes;
        this.grades = grades;
    }

    /**
     *
     * @return emptydatabase
     */
    public static Database emptyDatabase() {
        return new Database(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    //GETTERS

    /**
     *
     * @return list of subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     *
     * @return list of class
     */
    public List<Clazz> getClazzes() {
        return clazzes;
    }

    /**
     *
     * @return list of grades
     */
    public List<Marks> getGrades() {
        return grades;
    }
    //SETTERS

    /**
     *
     * @param subjects list of subjects
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     *
     * @param clazzes list fo classes
     */
    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    /**
     *
     * @param grades list of grades
     */
    public void setGrades(List<Marks> grades) {
        this.grades = grades;
    }

    /**
     *
     * @param clazz
     * @return
     * @throws ClazzNameException
     */
    public String addClazz(Clazz clazz) throws ClazzNameException {
        if(clazz.getName().length() > 15) {
            throw new ClazzNameException();
        }
        clazz.setId(generateId());
        this.clazzes.add(clazz);
        return clazz.getId();
    }

    /**
     *
     * @param subject subject
     * @return
     */
    public String addSubject(Subject subject) {
        subject.setId(generateId());
        this.subjects.add(subject);
        return subject.getId();
    }

    /**
     *
     * @param mark mark
     * @return
     */
    public String addGrade(Marks mark) {
        mark.setId(generateId());
        this.grades.add(mark);
        return mark.getId();
    }

    /**
     *
     * @return
     */
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
