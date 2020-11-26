package pl.polsl.model;
import java.io.Serializable;
/**
 * Subject Class contains only name and id of given subjects
 * @author Natalia Cheba
 * @version 1.0
 */
public class Subject implements Serializable {

    /*
     * id  -  id of subject
    */
    private String id; //id of subject
    
    /*
     * name - name of subject
    */
    private String name; // name of subject

    /**
     * CONSTRUCTOR WITHOUT PARAMETERS
     */
    public Subject() {
    }

    /**
     *
     * @param name name of subject
     */
    public Subject(String name) {
        this.name = name;
    }

    /**
     *
     * @param id id subject
     * @param name name of subject
     */
    public Subject(String id, String name) {
        this.id = id;
        this.name = name;
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
     * @return id
     */
    public String getId() {
        return id;
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
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
}
