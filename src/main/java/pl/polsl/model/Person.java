package pl.polsl.model;

import java.io.Serializable;
/**
 * Marks Class contain everything is needed to give student a grade
 * @author Natalia Cheba
 * @version 1.0
 */
public class Person implements Serializable {
    /*
     * id - id of student
    */
    private String id; // id student
    /*
     * name - name of student
    */
    private String name; //name of student
    /*
     * surname sutnrmae of student
    */
    private String surname; // surname of student
    //CONSTRUCTORS
    /**
     *
     * @param id
     */
    public Person(String id) {
        this.id = id;
    }

    /**
     * 
     */
    public Person() {
    }

    /**
     *
     * @param name name student
     * @param surname surname student
     */
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     *
     * @param id id student
     * @param name name student
     * @param surname surname student
     */
    public Person(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name name of student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname surname student
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return id student
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id id student
     */
    public void setId(String id) {
        this.id = id;
    }
}
