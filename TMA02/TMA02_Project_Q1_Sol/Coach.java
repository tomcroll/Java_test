import ou.*;
/**
 * Instances of the Coach class orchestrate repetitions of sprinting
 * for two FitnessFrog objects, sporty1 and sporty1.
 * 
 * @author M250 Module Team 
 * @version 1.4
 */

public class Coach
{
   // instance variables
   private FitnessFrog sporty1;
   private FitnessFrog sporty2;

   /**
    * Constructor for objects of class Coach.
    */
   public Coach(FitnessFrog fitnessFrog1, FitnessFrog fitnessFrog2)
   {
      super();
      this.sporty1 = fitnessFrog1;
      this.sporty2 = fitnessFrog2;
   }

   /**
    * Getter for sporty1.
    */
   public FitnessFrog getSporty1()
   {
      return this.sporty1;
   }  

   /**
    * Getter for sporty2.
    */
   public FitnessFrog getSporty2()
   {
      return this.sporty2;
   }   
      
   /**
    * Returns the number of repetitions (between 1 and 5 inclusive)
    * specified by the user via a dialogue box.
    */
   private int getNumberRepetitions()
   {
      String repetitionString;
      int repetitions = 0;
      boolean again = true;

      while (again)
      {
         repetitionString =
          OUDialog.request("Enter the number of repetitions for the training session");
          try
          {
              repetitions = Integer.parseInt(repetitionString);
              if ((repetitions < 1) || (repetitions > 5))
               {
                   OUDialog.alert("Entered value is outside range (between 1 and 5 inclusive)");
                }
                else
                {
                    again = false;
                }
            }
            catch (NumberFormatException e)
            {
                OUDialog.alert("String could not be converted to an integer");
            }
        
      }
      return repetitions;
   }    
   
   /**
    * To do for Part (ii)
    * 
    * Changes the colour of the Fitness Frog that has run the farthest to
    * yellow and croaks once. Returns no value.
    */
   private void announceFittestFrog()
   {
       //System.out.println(this.getSporty1().getTotalDistanceSprinted());
       //System.out.println(this.getSporty2().getTotalDistanceSprinted());
       if (this.getSporty1().getTotalDistanceSprinted() != this.getSporty2().getTotalDistanceSprinted() )
       {
           if (this.getSporty1().getTotalDistanceSprinted() > this.getSporty2().getTotalDistanceSprinted() )
           {
              this.getSporty1().setColour(OUColour.YELLOW);
              this.getSporty1().croak();
            }else
            {
                this.getSporty2().setColour(OUColour.YELLOW);
                this.getSporty2().croak();
                
            }
        }
   }
   
   /**
    * First checks if both Fitness Frogs are currently positioned on the running
    * track (black stones numbered 1 to 11). If so, readys the Fitness Frogs for
    * sprinting. Next requests the user for the number of repetitions via a dialogue
    * box. Then enters a loop whose length is equal to the number of repetitions.
    * On each iteration, gets each Fitness Frog to sprint in turn. Finally, announces
    * which of the Fitness Frogs has sprinted the furthest. Returns no value.
    */
    public void train()
    {
       int repetitions = 0;      

       this.getSporty1().resetTotalDistanceSprinted();
       this.getSporty2().resetTotalDistanceSprinted();
       repetitions = this.getNumberRepetitions();
       for (int count = 1; count <= repetitions; count++)
       {
         if ( (isOnBlackStones(sporty1)) && (isOnBlackStones(sporty2)) )
         {
             this.getSporty1().sprint();
             this.getSporty2().sprint();
            }
       }
       this.announceFittestFrog();
    }
    
   /**
    *
    *
    *
    *
    */
    private boolean isOnBlackStones(FitnessFrog aFitnessFrog)
    {
       return ((aFitnessFrog.getPosition() >= 1 ) && (aFitnessFrog.getPosition() <= 11));
    }
    
   /**
    * 
    * 
    * 
    * 
    */
   public void trainThem()
   {
       
       //try catch block needed
       if ( (!isOnBlackStones(sporty1)) || (!isOnBlackStones(sporty2)) )
         {
             this.getSporty1().sprint();
             this.getSporty2().sprint();
            }
   }
}