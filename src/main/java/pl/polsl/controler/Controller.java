package pl.polsl.controler;
import pl.polsl.Interfaces.DatabaseFileManager;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.Application.Application;
import pl.polsl.exceptions.ClazzNameException;
import pl.polsl.model.Clazz;
import pl.polsl.model.Database;

/**
 * Controller class. Controller class use database and manage it
 * @author Natalia Cheba
 * @version 1.0
 */

public class Controller implements DatabaseFileManager {

    
   // Controller dataController =  new Controller();
     /*
     * database - object database
     */
    private Database database; 
    
     /*
     * database - object database
     */
    private final String databaseFile = "database.xml";
    
     /*
     * database - object database
     */
    private final String databaseFilePath = System.getProperty("user.dir") + "/" + databaseFile;

    /**
     * Constructor
     */
    public Controller() {
        this.checkIfFileExists();
        this.readFileFromXml();
    }

    /**
     * Constructor
     * @return database 
     */
    public Database getDatabase() {
        if (this.database == null) {
            this.database = Database.emptyDatabase();
        }
        return database;
    }
    /**
     * Method chech if file exist. Return message 
     */
    public boolean checkIfFileExists() {
        File f = new File(databaseFilePath);
        if (!f.exists() || f.isDirectory()) {  // check is it exists
            return false;
        } 
        return true;
    }

    /**
     * Method save to XML. 
     */
    public void saveToFileXml() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(this.databaseFilePath); //output file
            BufferedOutputStream outputStream = new BufferedOutputStream(fileOutput);  // stream for output
            XMLEncoder encoder = new XMLEncoder(outputStream);
            encoder.writeObject(this.database); //save to file
            encoder.close(); // close
        } catch(Exception ex) {
            System.out.println("Zapis bazy danych do pliku nie powiódł sie");
        }
    }

    /**
     * Method read file from XML 
     */
    public void readFileFromXml() {
        try {
            FileInputStream fileInput = new FileInputStream(this.databaseFilePath); //input file
            BufferedInputStream inputStream = new BufferedInputStream(fileInput); //input stream
            XMLDecoder decoder = new XMLDecoder(inputStream); //decoder
            this.database = (Database) decoder.readObject(); //read database
            decoder.close(); //close 
        } catch(Exception ex) {
            System.out.println("Deserializacja pliku bazy danych nie powiodła sie");
        }
    }
   
   // public void putClassInDatabase(String className ) throws ClazzNameException
  //  {
      
   //   Clazz clazz = new Clazz(); // for random
  //   clazz.setName(className);
   //   clazz.setPupils(new ArrayList<>()); // new class has new list of stduents
  //    this.dataController.getDatabase().addClazz(clazz);
   //   dataController.saveToFileXml();
        
        
   // }

}
