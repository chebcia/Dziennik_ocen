import java.util.ArrayList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.exceptions.ClazzNameException;
import pl.polsl.exceptions.PersonNameException;
import pl.polsl.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Natalia Cheba
 */

public class DatabaseTest {

    /*
     * database - database
    */
    Database database;

    @BeforeEach
    public void setUp() {
        database = Database.emptyDatabase();
    }

    /**
     * Test check is it correct add class
     * @param strings
     * @throws ClazzNameException
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "Klasa 1",
            "Klasa 2a",
            "Klasa 123143"
    })
    public void testAddClazz(String strings) throws ClazzNameException {
        // given
        Clazz testClazz = new Clazz("Testowa klasa 1", new ArrayList<>());
        // when
        String id = this.database.addClazz(testClazz);
        // then
        assertTrue(this.database.getClazzes().stream().anyMatch(c -> c.getId().equals(id)));
    }

    /**
     * Test check is it correct add subject to the class  
     * @param subjectName
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "Chemia",
            "Fizyka",
            "Matematyka",
            "Programowanie"
    })
    public void testAddSubject(String subjectName) {
        // given
        Subject subject = new Subject(subjectName);
        // when
        String id = this.database.addSubject(subject);
        // then
        assertTrue(this.database.getSubjects().stream().anyMatch(c -> c.getId().equals(id)));
    }

    /**
     * Test check is it correct add student to the class 
     * @param pupilName name of student
     * @throws ClazzNameException
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "Uczen",
            "Wzorowy",
            "Kowalski", ""
    })
    public void addPupilToClazz(String pupilName) throws ClazzNameException {
        // given
        Clazz testClazz = new Clazz("Testowa klasa 1", new ArrayList<>());
        Person person = new Person(this.database.generateId(), pupilName, "Uzytkownik");
        testClazz.getPupils().add(person);
        // when
        this.database.addClazz(testClazz);
        // then
        assertTrue(this.database.getClazzes().stream().anyMatch(c -> c.getPupils().contains(person)));
    }

    /**
     * Test for add grade for student
     * @param gradeType type of grade
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "Laboratoria",
            "Egzamin",
            "Cwiczenia",
            "testowa przedmiot 112312312312312312312"
    })
    public void addGrade(String gradeType) {
        // given
        Clazz testClazz = new Clazz("Testowa klasa 1", new ArrayList<>());
        Person person = new Person(this.database.generateId(), "Testowy", "Uzytkownik");
        Subject subject = new Subject("Testowy Przedmiot 2");
        testClazz.getPupils().add(person);
        Marks grade = new Marks(person.getId(), testClazz.getId(), subject.getId(), 5, 3, gradeType);
        // when
        String id = this.database.addGrade(grade);
        // then
        assertTrue(this.database.getGrades().stream().anyMatch(g -> g.getId().equals(id)));
    }

    /**
     * Test if id is equal
     */
    @Test
    public void generateUniqueId() {
        String id1 = this.database.generateId();
        String id2 = this.database.generateId();
        assertTrue(id1 instanceof String);
        assertNotEquals(id2, id1);
    }

    /**
     * Test check length of given word - name of class 
     * @param clazzName class name
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "testowa klasa 112312312312312312312",
            "aaaaaaaaaaaaaaa",
    })
    public void clazzNameExceptionCheck(String clazzName) {
        // given
        Clazz testClazz = new Clazz(clazzName, new ArrayList<>());
        // when
        assertThrows(ClazzNameException.class, () -> this.database.addClazz(testClazz));
    }

    /**
     * Test check length of given word - person name
     * @param personName name of student
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "Zadle",
            "aaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaa",
            "Rhoshandiatellyneshiaunneveshenk"
    })
    public void pupilNameExceptionCheck(String personName) {
        // given
        Person pupil = new Person(personName, "Nazwisko");
        Clazz testClazz = new Clazz("Klasa 1", new ArrayList<>());
        // when
        assertThrows(PersonNameException.class, () -> testClazz.addPupil(pupil));
    }
}
