import java.io.File;

/**
 * The Runnable interface specifies a run method used to execute the program.
 * 
 * @author Leo Ureel
 * @COURSE CS 1122
 * @TERM   SPRING 2016
 */
public interface Runnable {
   /**
    * The run method is used as the starting point for running your code.
    * 
    * This method should load the input data file, process the data, then write
    * the data to the output file. (NOTE: Because of modularization, these 
    * operations should be contained is small methods that do only one thing.)
    * 
    * Input and output file formats are identical.
    * Each line of the data file is a record that contains the following fields:
    * 
    *    A unique, integer representing the real estate listing
    *    An integer representing the sale price of house
    *    A double representing the distance (miles) from the house to Joe's work
    *    An integer representing the square-footage of the house.
    *    
    * Example:
    *    4411 133000 22.2 1200 
    *    4412 157000 31.6 1950
    *    4412 800000 89.7 32850
    * 
    * @param inputFile  - File descriptor for the input data file.
    * @param outputFile - File descriptor for the output file.
    */
   public void run( File inputFile, File outputFile );
}