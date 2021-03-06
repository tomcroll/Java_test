/* import statement */
import java.io.*;
import java.util.*;
import ou.*;

// To be added by students in Question 3, part (iv)

/**
 * Class Runner - Simulates a runner in a Marathon. This is the first iteration which
 * does not implement the Comparable interface. This code will not compile due to the 
 * change of filename, however it is included to show the first solution.
 * 
 * @author Tom Croll 
 * @version Version 1.0
 */
public class Runner 
{
/* static variables */
    private static int nextNumber = 1;
// To be added by students in Question 3, part (i)(a) and part(iv)(a)

/* instance variables */
     
   private int number;       // runner's number
   private String name;      // runner's name
   private String ageGroup;  // standard, junior or senior
   private int time;         // runner's marathon time in minutes
 
   
   /**
    * Default constructor for objects of class Runner.
    */
   public Runner()
   {
      super();
      this.name = "";
      this.ageGroup = "standard";
      this.time = 0;
      
    // additional code to be added by students in Q3, part (i)(b)
      this.number = Runner.nextNumber;
      Runner.nextNumber = Runner.nextNumber +1;
    }

/* instance methods */

    //Only those accessor methods that you will need have been included
        
   /**
    * Returns the receiver's number.
    */
   public int getNumber()
   {
      return this.number;
   }
   
   
   /**
    * Sets the receiver's name.
    */
   public void setName(String aName)
   {
      this.name = aName;
   }
   
   
   /**
    * Returns the receiver's name.
    */
   public String getName()
   {
      return this.name;
   }
   
   
   /**
    * Sets the receiver's ageGroup.
    */
   public void setAgeGroup(String group)
   {
      this.ageGroup = group;
   }

   /**
    * Returns the receiver's ageGroup.
    */
   public String getAgeGroup()
   {
      return this.ageGroup;
   }
    
   
   /**
    * Sets the receiver's time.
    */
   public void setTime(int aTime)
   {
      this.time = aTime;
   }
   
   
   /**
    * Returns the receiver's time.
    */
   public int getTime()
   {
      return this.time;
   }
   
}
