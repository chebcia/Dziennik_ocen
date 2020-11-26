package pl.polsl.view;

import pl.polsl.controler.Controller;
import pl.polsl.exceptions.ClazzNameException;
import pl.polsl.exceptions.DialogExitException;
import pl.polsl.model.Clazz;
import pl.polsl.model.Marks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import pl.polsl.Utils.InputUtilImpl;
import pl.polsl.model.Person;
import pl.polsl.model.Subject;

/**
 * Subject Class is class uses with contact with user
 *
 * @author Natalia Cheba
 * @version 1.0
 */

public class UserDialog {
    /*
     * inputUtilImpl - reading from the console
    */
    private final InputUtilImpl inputUtilImpl; 
    /*
     * dataController - manage database
    */
    private final Controller dataController;

    //Constructors

    /**
     * @param dataController
     */
    public UserDialog(Controller dataController) {
        this.inputUtilImpl = new InputUtilImpl();
        this.dataController = dataController;
    }

    private final List<String> actions = new ArrayList<>() {{
        add("Dodaj przedmiot");
        add("Dodaj ocene");
        add("Dodaj klase");
        add("Dodaj ucznia do klasy");
        add("Wyświetl dane");
        add("Wyjdz");
    }};

    /**
     * What you want to do?
     * 1 I want to add an item
     2. I want to add a grade
     - class (choose)
     - student (select)
     - subject (select)
     - enter the rating + weight (enter) + type
     3. Add a class
     - name (enter)
     4. Add a student to the class
     - class (choose)
     - name and surname of the student (enter)
     5. View the data
     6. Exit

     */

    /**
     * Method use to choose options
     *
     * @return
     */
    public boolean actionPick() {
        try {
            int actionNumber = inputUtilImpl.readConsoleSelect("Wybierz akcje: ", this.actions);
            switch (actionNumber) {
                case 0:
                    addSubject();
                    break;
                case 1:
                    addGrade();
                    break;
                case 2:
                    addClazz();
                    break;
                case 3:
                    addPupilToClazz();
                    break;
                case 4:
                    showData();
                    break;
                case 5:
                    return false;
            }
            return true;
        } catch (DialogExitException ex) {
            return true;
        } catch (ClazzNameException e) {
            System.out.printf("Podana nazwa klasy jest błędna");
            return true;
        }
    }

    /**
     * Method add Subject
     */

    private void addSubject() {
        Subject subject = new Subject(); // UUID for random
        subject.setName(inputUtilImpl.readConsoleInput("Podaj nazwe przedmiotu: ", s -> s));
        this.dataController.getDatabase().addSubject(subject); //add
    }

    /**
     * Method add Class
     */

    private void addClazz() throws ClazzNameException {
        Clazz clazz = new Clazz(); // for random
        clazz.setName(inputUtilImpl.readConsoleInput("Podaj nazwe klasy: ", s -> s));
        clazz.setPupils(new ArrayList<>()); // new class has new list of stduents
        this.dataController.getDatabase().addClazz(clazz);
    }

    /**
     * Method add student to Class
     */
    private void addPupilToClazz() throws DialogExitException {
        // choosing class 
        int clazzNumber = inputUtilImpl.readConsoleSelect("Wybierz klase: ", this.dataController.getDatabase()
                .getClazzes().stream().map(Clazz::getName).collect(Collectors.toList()));
        Clazz clazz = this.dataController.getDatabase().getClazzes().get(clazzNumber);
        // choosing student
        Person pupil = new Person(UUID.randomUUID().toString()); //random
        pupil.setName(inputUtilImpl.readConsoleInput("Podaj imie ucznia: ", s -> s));
        pupil.setSurname(inputUtilImpl.readConsoleInput("Podaj nazwisko ucznia: ", s -> s));
        clazz.getPupils().add(pupil);
    }

    /**
     * Method add grade for student
     */
    private void addGrade() throws DialogExitException {
        // choosing class
        int clazzNumber = inputUtilImpl.readConsoleSelect("Wybierz klase: ", this.dataController.getDatabase()
                .getClazzes().stream().map(Clazz::getName).collect(Collectors.toList()));
        Clazz clazz = this.dataController.getDatabase().getClazzes().get(clazzNumber);
        //choosing student
        int pupilNumber = inputUtilImpl.readConsoleSelect("Wybierz ucznia: ", clazz.getPupils().stream()
                .map(p -> p.getName() + " " + p.getSurname()).collect(Collectors.toList()));
        Person pupil = clazz.getPupils().get(pupilNumber);
        //chosing subject
        int subjectNumber = inputUtilImpl.readConsoleSelect("Wybierz przedmiot: ", this.dataController.getDatabase()
                .getSubjects().stream().map(Subject::getName).collect(Collectors.toList()));
        Subject subject = this.dataController.getDatabase().getSubjects().get(subjectNumber);
        // add mark to student
        int gradeNumber = inputUtilImpl.readConsoleInput("Podaj ocene (numerycznie): ", UserDialog::validateGradeInput); //check number
        int gradeWeight = inputUtilImpl.readConsoleInput("Podaj wage oceny (numerycznie): ", UserDialog::validateGradeInput);  //check number
        String gradeType = inputUtilImpl.readConsoleInput("Ocena za: ", s -> s);
        Marks grade = new Marks(
                pupil.getId(),
                clazz.getId(),
                subject.getId(),
                gradeNumber,
                gradeWeight,
                gradeType
        );
        this.dataController.getDatabase().addGrade(grade); //add mark
    }

    /**
     * Method show all data which is in database
     */
    private void showData() {
        for (Clazz clazz : this.dataController.getDatabase().getClazzes()) { // get class
            for (Person pupil : clazz.getPupils()) { // get student
                System.out.println("Oceny ucznia " + pupil.toString() + ":");
                List<Marks> grades = this.getPupilGradesById(pupil.getId());
                for (Marks grade : grades) { //get marks
                    String subjectName = this.getSubjectNameById(grade.getSubjectId()).getName();
                    System.out.println(subjectName + ": " + grade.toString());
                }
            }
        }
    }

    /**
     * Method return subject by name. It's use in showdata() to divide functions
     */
    private Subject getSubjectNameById(String subjectId) {
        return this.dataController.getDatabase()
                .getSubjects()
                .stream()
                .filter(s -> s.getId().equals(subjectId)) //lambda expression
                .findAny() //filter only the same names
                .orElse(null); //or return null
    }

    /**
     * Method return grades from students
     */
    private List<Marks> getPupilGradesById(String pupilId) {
        return this.dataController.getDatabase().getGrades().stream()
                .filter(g -> g.getPupilId().equals(pupilId)) // filter the same name
                .collect(Collectors.toList()); // toList because its list
    }

    /**
     * Method check value from user if it is between 0 and 6 and return grade
     */
    private static Integer validateGradeInput(String input) throws NumberFormatException {
        int grade = Integer.parseInt(input);
        if (grade > 6 || grade < 0) {
            throw new NumberFormatException("");
        }
        return grade;
    }
}