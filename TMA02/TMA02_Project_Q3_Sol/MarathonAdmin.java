/* import statement */
import java.io.*;
import java.util.*;
import ou.*;
import java.util.Random;


/**
 * Write a description of class MarathonAdmin here.
 * 
 * @author Tom Croll 
 * @version 1.0
 */
public class MarathonAdmin
{
    private List<Runner> runners;
    private Map<TreeSet, int> juniorResults;
    private Map<TreeSet, int> standardResults;
    private Map<TreeSet, int> seniourResults;
    

    /**
     * Constructor for objects of class MarathonAdmin
     */
    public MarathonAdmin()
    {
        this.runners = new ArrayList<>();
    }
    
    /**
     * Helper method to decide runner age group
     * @param int anAge
     * @return String ageGroup
     */
    private String getAgeGroup(int anAge)
    {
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
     */
    public void readInRunners()
    {
        int age;
        String pathname = OUFileChooser.getFilename();
        File aFile = new File(pathname);
        if (!aFile.exists())
        {
            OUDialog.alert("No physical file exists!");
        }
        Scanner bufferedScanner = null;
        try
        {
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
                lineScanner.useDelimiter(",");
                runnerName = lineScanner.next();
                runnerAge = lineScanner.nextInt();
                ageGroup = getAgeGroup(runnerAge);
                Runner r = new Runner();
                r.setName(runnerName);
                r.setAgeGroup(this.getAgeGroup(runnerAge));
                runners.add(r);
            }
        }
        catch (Exception anException)
        {
            System.out.println("Error " + anException);
        }
        finally
        {
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
        //Random randomTime;
        for (Runner eachRunner: runners)
        {
            eachRunner.setTime(getRunTime());
        }
    }
    
    /**
     * Public method that takes no arguments and returns no value. The method sorts the 
     * receiver's runners list by the time each runner has taken to complete the marathon
     * so that the fastest runner is first in the list and so on...
     */
    public void sortRunnerList()
    {
        Collections.sort(runners);
        
        for (Runner eachRunner: runners)
        {
            System.out.println("Runner " + eachRunner.getName() + " - Time: " + eachRunner.getTime());
        }
    }
        

}
