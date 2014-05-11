/* import statement */
import java.io.*;
import java.util.*;
import ou.*;


/**
 * Class MarathonAdmin simulates and monitors the registration and performance of runners
 * in a marathon. Firstly, it reads in data from a CSV text file in order to create Runner
 * objects, then simulates running the marathon, assigning random times and storing the
 * results in appropriate objects
 * 
 * @author Tom Croll 
 * @version 1.0
 */
public class MarathonAdmin
{
    private List<Runner> runners;
    private SortedMap<String, Integer> juniorResults;
    private SortedMap<String, Integer> standardResults;
    private SortedMap<String, Integer> seniorResults;
    

    /**
     * Constructor for objects of class MarathonAdmin
     */
    public MarathonAdmin()
    {
        this.runners = new ArrayList<>();
        this.juniorResults = new TreeMap<>();
        this.standardResults = new TreeMap<>();
        this.seniorResults = new TreeMap<>();
    }
    
    /**
     * Helper method to decide runner age group
     * @param int anAge
     * @return String ageGroup - either "junior", "standard" or "senior"
     */
    private String getAgeGroup(int anAge)
    {
        /** Logic to assign a String value according to age range of runners. A switch 
         * statement would have been more concise here, however nested if statements were
         * used in first draft to ensure functionality.
         * Error checking could be added to ensure anAge is not negative or null, or even
         * unrealistically high! i.e. > 130
         */
        String ageGroup;
        if (anAge < 18)
        {
            ageGroup = "junior";
        }
        else
        {
            if (anAge >= 55)
            {
                ageGroup = "senior";
            }
            else
            {
                ageGroup = "standard";
            }
        }
        return ageGroup;
    }

    /**
     * Improved helper method to decide runner age group. This time error checking
     * has been added to help sanitise the data. I have made the assumption that and
     * age of 0, less than 5 or greater than 130 is not realistic data for a marathon
     * runner, so used a combination of an assertion and exceptions to improve the
     * robustness of the code. Further reasoning provided in comments below.
     * @param int anAge - must be postive, greater than 5 and less than 130 years old
     * @return String ageGroup - either "junior", "standard" or "senior"
     */
    private String getAgeGroup2(int anAge)
    {
        /** Logic to assign a String value according to age range of runners. A switch 
         * statement would have been more concise here, however nested if statements were
         * used for readablitiy.
         * Error checking has been added to ensure anAge is not negative or null, or even
         * unrealistically high! i.e. > 130
         * As this is a private helper method, we could use assertions, however they process
         * text files of runners which could be supplied by the user, therefore I've chosen
         * to show both methods, an assert method to check for a 0 value and
         * IllegalArgumentExceptions if supplied age is outwith the realistic age.
         * N.B. coding style is a little different in this case as I think the indentation
         * is clearer. This is a deliberate improvement and not an inconsistency!
         */
        String ageGroup;
        assert anAge != 0 : "Age is 0";
        if (anAge < 5)
        {
            throw new IllegalArgumentException("Age is less than 5 years old. Cannot run Marathon");
        }
        else if (anAge > 130)
        {
            throw new IllegalArgumentException("Age is greater than 130 years old. Cannot run Marathon");
        }
        else if (anAge < 18)
        {
            ageGroup = "junior";
        }
        else if (anAge >= 55)
        {
            ageGroup = "senior";
        }
        else
        {
            ageGroup = "standard";
        }
        return ageGroup;
    }
    
    
    /**
     * Method will read from a selected file (should be runners.txt)
     * and create a runner object from a chosen text file with comma separated values
     */
    public void readInRunners()
    {
        int age;
        String pathname = OUFileChooser.getFilename();
        File aFile = new File(pathname);
        
        // Assert method included. Not strictly correct as this is user input 
        // from a public method so should alert with an exception
        // during normal running of code, but included to show understanding
        assert aFile.exists() : "File does not exist or cannot be read";
        
        // Alert to warn if aFile does not exist or cannot be read. Implemented above with an assertion
        // but could more appropriately throw and catch an IllegalArguementException as 
        // this is a public method. The caught error could stop the program from failing
        // and prompt the user to select another file, but this is outside the scope of this
        // task.
        if (!aFile.exists())
        {
            OUDialog.alert("No physical file exists!");
            throw new IllegalArgumentException("File does not exist or cannot be read");
        }
        
        Scanner bufferedScanner = null;
        try
        {
            // Initialise variables
            String runnerName;
            String ageGroup;
            int runnerAge;
            Scanner lineScanner;
            String currentLine;
            // Wrap in Scanner class in order to use hasNextLine() method
            bufferedScanner = new Scanner(new BufferedReader(new FileReader(aFile)));
            while (bufferedScanner.hasNextLine())
            {
                currentLine = bufferedScanner.nextLine();
                lineScanner = new Scanner(currentLine);
                // Assign comma as delimiter
                lineScanner.useDelimiter(",");
                runnerName = lineScanner.next();
                runnerAge = lineScanner.nextInt();
                Runner r = new Runner();
                r.setName(runnerName);
                // Use helper method to set age group
                r.setAgeGroup(this.getAgeGroup(runnerAge));
                // Add Runner r to runners list
                runners.add(r);
            }
        }
        catch (Exception anException)
        {
            System.out.println("Error " + anException);
        }
        finally
        {
            // Try to close the scanner and throw exception if error occurs
            try
            {
                bufferedScanner.close();
            }
            catch (Exception anException)
            {
                System.out.println("Error " + anException);
            }
        }
    }
    
    /**
     * Helper method to get random number for marathon time of each Runner.
     * @param
     * @return random number between 90 and 180
     */
    private int getRunTime()
    {
        /** Return random number between 0 and 90, then add 90 to
         * create range of 90 - 180
         */
        Random randomTime = new Random();
        return (randomTime.nextInt(89) + 90);
    }
    
    /**
     * Pulic method that takes no args and returns no value. Method will iterate over 
     * the runners and assign a random number in the range 90 - 180 inclusive for
     * the time attribute
     */
    public void runMarathon()
    {
        for (Runner eachRunner: runners)
        {
            eachRunner.setTime(getRunTime());
        }
    }
    
    /**
     * Public method that takes no arguments and returns no value. The method sorts the 
     * receiver's runners list by the time each runner has taken to complete the marathon
     * so that the fastest runner is first in the list and so on.
     */
    public void sortRunnerList()
    {
        Collections.sort(runners);
        /** Output to command line for clarity of functionality. This isn't strictly requested,
         * however allows me to show the results in a useful format.
         */
        for (Runner eachRunner: runners)
        {
            System.out.println("Runner " + eachRunner.getName() + " - Time: " + eachRunner.getTime() + " Age Group: " + eachRunner.getAgeGroup());
        }
    }
    
    /**
     * Public instance method which takes no arguments and returns no value. The method
     * iterates over the runners, populating the maps juniorResults, standardResults and
     * seniorResults with the names and times of each category of runner
     */
    public void categorise()
    {
        for (Runner eachRunner: runners)
        {
            if (eachRunner.getAgeGroup().equals("junior"))
            {
                juniorResults.put(eachRunner.getName(), eachRunner.getTime());
            }
            else if (eachRunner.getAgeGroup().equals("standard"))
            {
                standardResults.put(eachRunner.getName(), eachRunner.getTime());
            }
            else if (eachRunner.getAgeGroup().equals("senior"))
            {
                 seniorResults.put(eachRunner.getName(), eachRunner.getTime());
            }
            else
            {
                
                /** Warn if age group is invalid. This should be unnecessary as age group can
                 * only be assigned values via this class, however this is an example of defensive programming
                 * An assert statement would perhaps be more appropriate as this is more useful for testing
                 * purposes, however I've left it in this format for clarity.
                 */
                System.out.println("Runner " + eachRunner.getName() + " has invalid Age Group!");
            }       
        }
    }
                
}
