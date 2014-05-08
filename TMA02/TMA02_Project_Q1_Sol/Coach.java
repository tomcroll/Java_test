import ou.*;
/**
 * Instances of the Coach class orchestrate repetitions of sprinting
 * for two FitnessFrog objects, sporty1 and sporty1.
 * 
 * @author Tom Croll
 * @version 1.0
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
       if ( (isOnBlackStones(sporty1)) && (isOnBlackStones(sporty2)) )
       {
         int repetitions = 0;      

         this.getSporty1().resetTotalDistanceSprinted();
         this.getSporty2().resetTotalDistanceSprinted();
         repetitions = this.getNumberRepetitions();
         for (int count = 1; count <= repetitions; count++)
         { 
             this.getSporty1().sprint();
             this.getSporty2().sprint();
            }
       
       this.announceFittestFrog();
      }
    }
    
   /**
    * For part (v)
    * Checks to see if both frogs are on black squares (1-11) and returns
    * true if so. Otherwise returns false
    *
    */
    private boolean isOnBlackStones(FitnessFrog aFitnessFrog)
    {
       return ((aFitnessFrog.getPosition() >= 1 ) && (aFitnessFrog.getPosition() <= 11));
    }
    
   /**
    * For part (vi)
    * First checks if both Fitness Frogs are currently positioned on the running
    * track (black stones numbered 1 to 11). If so, readys the Fitness Frogs for
    * sprinting. Next requests the user for the number of repetitions via a dialogue
    * box. Then enters a loop whose length is equal to the number of repetitions.
    * On each iteration, gets each Fitness Frog to sprint in turn. Finally, announces
    * which of the Fitness Frogs has sprinted the furthest. Returns no value.
    * @throws IllegalStateException if frogs are not on running track in order to train
    * 
    */
   public void trainThem()
   {
       try {
           if ( (!isOnBlackStones(sporty1)) || (!isOnBlackStones(sporty2)) )
           {
               throw new IllegalStateException("Training cannot take place since both Fitness Frogs are not on the racing track");
            } else
            { 
                int repetitions = 0;
                
                this.getSporty1().resetTotalDistanceSprinted();
                this.getSporty2().resetTotalDistanceSprinted();
                repetitions = this.getNumberRepetitions();
                for (int count = 1; count <= repetitions; count++)
                { 
                    this.getSporty1().sprint();
                    this.getSporty2().sprint();
                }
       
                this.announceFittestFrog();
            }
            
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            
        }

   }
}
