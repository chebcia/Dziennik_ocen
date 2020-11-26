package pl.polsl.model;
import pl.polsl.exceptions.PersonNameException;

import java.io.Serializable;
import java.util.List;

/**
 * Clazz contains name of class, id and list of students
 * @author Natalia Cheba
 * @version 1.0
 */

public class Clazz implements Serializable {

     /*
     * id - id of class
     */
    
    private String id; // id 
    
     /*
     * name - name of class
     */
    
    private String name; // nazwa klasy
     /*
     * id - list of students
     */
    
    private List<Person> pupils; // students

    // CONSTRUCTORS 

    /**
     *
     */
    public Clazz() {
    }

    /**
     *
     * @param name name of student
     * @param pupils list of students 
     */
    public Clazz(String name, List<Person> pupils) {
        this.name = name;
        this.pupils = pupils;
    }

    /**
     *
     * @param id id 
     * @param name name of class 
     * @param pupils list of students
     */
    public Clazz(String id, String name, List<Person> pupils) {
        this.id = id;
        this.name = name;
        this.pupils = pupils;
    }
    //GETTERS

    /**
     *
     * @return name of class
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return list of students
     */
    public List<Person> getPupils() {
        return pupils;
    }
    
    /**
     *
     * @return id 
     */
    public String getId() {
        return id;
    }

    // SETTERS

    /**
     *
     * @param name name of class
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param pupils list of students
     */
    public void setPupils(List<Person> pupils) {
        this.pupils = pupils;
    }

    /**
     *
     * @param id id 
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     *
     * @param p student
     * @throws PersonNameException
     */
    public void addPupil(Person p) throws PersonNameException {
        if(p.getName().length() > 15) {
            throw new PersonNameException();
        }
        this.getPupils().add(p);
    }
}
