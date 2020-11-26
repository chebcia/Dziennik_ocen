package pl.polsl.Interfaces;

public interface DatabaseFileManager {

    /**
     *
     * @return
     */
    boolean checkIfFileExists();

    /**
     *
     */
    void saveToFileXml();

    /**
     *
     */
    void readFileFromXml();

}
