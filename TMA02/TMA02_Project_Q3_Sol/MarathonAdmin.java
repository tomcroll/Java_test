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
     * @return String ageGroup
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
     * Method will read from a selected file (should be runners.txt)
     * and create a runner object from a chosen text file with comma separated values
     */
    public void readInRunners()
    {
        int age;
        String pathname = OUFileChooser.getFilename();
        File aFile = new File(pathname);
        // Alert to warn if aFile exists. Could have been implemented with an assertion
        if (!aFile.exists())
        {
            OUDialog.alert("No physical file exists!");
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
            bufferedScanner = new Scanner(new BufferedReader(new FileReader(aFile)));
            while (bufferedScanner.hasNextLine())
            {
                currentLine = bufferedScanner.nextLine();
                lineScanner = new Scanner(currentLine);
                // Assign comma as delimiter
                lineScanner.useDelimiter(",");
                runnerName = lineScanner.next();
                runnerAge = lineScanner.nextInt();
                // Use helper method to set age group
                ageGroup = getAgeGroup(runnerAge);
                Runner r = new Runner();
                r.setName(runnerName);
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
     * Helper method to get random number for time
     */
    private int getRunTime()
    {
        /** Return random number with offset of between 0 and 90, then add 90
         * create range of 90 - 180
         */
        Random randomTime = new Random();
        return (randomTime.nextInt(89) + 90);
    }
    
    /**
     * pulic method that takes no args and returns no value. Method will iterate over 
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
            //String ageGroup = eachRunner.getAgeGroup();
            if (eachRunner.getAgeGroup().equals("junior"))
            {
                juniorResults.put(eachRunner.getName(), eachRunner.getTime());
            }
            else
                if (eachRunner.getAgeGroup().equals("standard"))
                {
                    standardResults.put(eachRunner.getName(), eachRunner.getTime());
                }
                else
                    if (eachRunner.getAgeGroup().equals("senior"))
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
