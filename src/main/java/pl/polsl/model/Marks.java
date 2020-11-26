package pl.polsl.model;

import java.io.Serializable;

/**
 * Marks Class contain everything is needed to give student a grade
 * @author Natalia Cheba
 * @version 1.0
 * 
 */
public class Marks implements Serializable {
    /*
     * id - id of mark
    */
    private String id; // id mark
     /*
     * pupilId - id of student
    */
    private String pupilId; // id student
     /*
     * classId - id of class
    */
    private String classId; // id class
    
     /*
     * subjectId - id of subject
    */
    private String subjectId; // id subject
     /*
     * mark - mark
    */
    private int mark; // mark
     /*
     * weight - weight of mark
    */
    private int weight; // weight
     /*
     * type - type of exam
    */
    private String type; //type of exam
    
//CONSTRUCTORS
    /**
     *
     * @return 
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type type 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @param id id of mark
     */
    public Marks(String id) {
        this.id = id;
    }

    /**
     *
     */
    public Marks() {
    }

    /**
     *
     * @param pupilId id of pupil
     * @param classId id of class 
     * @param subjectId id of subject
     * @param mark mark
     * @param weight weight of mark
     * @param type type of mark
     */
    public Marks(String pupilId, String classId, String subjectId, int mark, int weight, String type) {
        this.pupilId = pupilId;
        this.classId = classId;
        this.subjectId = subjectId;
        this.mark = mark;
        this.weight = weight;
        this.type = type;
    }

    /**
     *
     * @param id id of mark
     * @param pupilId id of student
     * @param classId id of class
     * @param subjectId id of subject
     * @param mark mark
     * @param weight weight of mark
     * @param type type of exam
     */
    public Marks(String id, String pupilId, String classId, String subjectId, int mark, int weight, String type) {
        this.id = id;
        this.pupilId = pupilId;
        this.classId = classId;
        this.subjectId = subjectId;
        this.mark = mark;
        this.weight = weight;
        this.type = type;
    }

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return "ocena : " + this.mark + ", waga: " + this.weight + ", typ: " + this.type;
    }

    // GETTERY
    
    /**
     *
     * @return value of weight from mark
     */
    public int getWeight() {
        return weight;
    }

    /**
     *
     * @return id student
     */
    public String getPupilId() {
        return pupilId;
    }
    
     /**
     *
     * @return id of class
     */
    public String getClassId() {
        return classId;
    }
    
    /**
     *
     * @return id of subject
     */
    public String getSubjectId() {
        return subjectId;
    }
    /**
     *
     * @return mark
     */
    public int getMark() {
        return mark;
    }
    /**
     *
     * @return id student
     */
    public String getId() {
        return id;
    }
    
    //SETTERY 
    /**
     *
     * @param weight weight of mark
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    /**
     *
     * @param pupilId id student
     */
    public void setPupilId(String pupilId) {
        this.pupilId = pupilId;
    }
    /**
     *
     * @param classId id of class 
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     *
     * @param subjectId id of subject
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
     *
     * @param id id of mark
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param mark mark
     */
    public void setMark(int mark) {
        this.mark = mark;
    }
    
   
}
