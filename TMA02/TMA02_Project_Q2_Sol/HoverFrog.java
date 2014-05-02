/**
 * The class HoverFrog is a subclass of Frog with the additional instance variable height
 * and an additional protocol to initialise and use height.
 *
 * @author M250 Module Team
 * @version 1.0
 */
public class HoverFrog extends Frog
{
   /* Instance variable */
   /** The current hovering height of the HoverFrog (in the range 0-6). */
   private int height;

   /**
    * Constructor for objects of class HoverFrog which has the default characteristics
    * of a frog and initialises height to 0.
    */
   public HoverFrog()
   {
      super();
      this.height = 0;
   }

   /* Instance methods */

   /**
    * Returns the height of the receiver.
    */
   public int getHeight()
   {
      return this.height;
   }

   /**
    * Sets the height of the receiver to the value of the argument aHeight.
    * aHeight must lie in the range 0-6 otherwise the method does nothing.
    */
   public void setHeight(int aHeight)
   {
      if ((aHeight >= 0) && (aHeight <= 6))
      {
         this.height = aHeight;
         this.update("height");
      }
   }

   /**
    * Increases the height of the receiver by the value of the argument stepChange.
    * The new height of the receiver must lie in the range 0-6 otherwise the method 
    * does nothing.
    */
   public void upBy(int stepChange)
   {
      this.setHeight(this.getHeight() + stepChange);
   }

   /**
    * Decreases the height of the receiver by the value of the argument stepChange.
    * The new height of the receiver must lie in the range 0-6 otherwise the method 
    * does nothing.
    */
   public void downBy(int stepChange)
   {
      this.setHeight(this.getHeight() - stepChange);
   }

   /**
    * If the height of the receiver is greater than 0 decrements the height of the receiver 
    * by 1, otherwise the method does nothing.
    */
   public void down()
   {
      this.downBy(1);
   }

   /**
    * If the height of the receiver is less than 6 increments the height of the receiver by 1,
    * otherwise the method does nothing.
    */
   public void up()
   {
      this.upBy(1);
   }

   /**
    * Resets the receiver to its home position and to a height of 0.
    */
   @Override
   public void home()
   {
      super.home();
      this.setHeight(0);
   }

   /**
    * Returns a string representation of the receiver.
    */
   @Override
   public String toString()
   {
      return super.toString() + ", height " + this.getHeight();
   }

}
