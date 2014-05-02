/**
 * Account class used to model simple bank accounts, allowing money 
 * to be credited to, and debited and transfered from, an account.
 *
 * @author M250 Module Team
 * @version 1.2
 */

public class Account
{
   /* instance variables */
   private String holder;
   private String number;
   private double balance;

   /**
    * Constructor for objects of class Account.
    */
   public Account()
   {
      super();   // optional
      this.holder = "";
      this.number = "";
      this.balance = 0.0;
   }

   /**
    * Constructor for objects of class Account which sets the values of the 
    * holder, number and balance of the receiver to the arguments 
    * aHolder, aNumber and aBalance respectively.
    */
   public Account(String aHolder, String aNumber, double aBalance)
   {
      super(); // optional
      this.holder = aHolder;
      this.number = aNumber;
      this.balance = aBalance;
   }

   /* instance methods */

   /**
    * Returns the balance of the receiver.
    */
   public double getBalance()
   {
      return this.balance;
   }

   /**
    * Set the balance of the receiver to the value of the argument aBalance.
    */
   public void setBalance(double aBalance)
   {
      this.balance = aBalance;
   }

   /**
    * Returns the holder of the receiver.
    */
   public String getHolder()
   {
      return this.holder;
   }

   /**
    * Returns the number of the receiver.
    */
   public String getNumber()
   {
      return this.number;
   }

   /**
    * Set the number of the receiver to the value of the argument aNumber.
    */
   public void setNumber(String aNumber)
   {
      this.number = aNumber;

   }

   /**
    * Set the holder of the receiver to the value of the argument aHolder.
    */
   public void setHolder(String aHolder)
   {
      this.holder = aHolder;
   }

   /**
    * Credits the receiver with the value of the argument anAmount.
    */
   public void credit(double anAmount)
   {
      this.setBalance(this.getBalance() + anAmount);
   }

   /**
    * If the balance of the receiver is equal to or greater than the argument anAmount,
    * the balance of the receiver is debited by the argument anAmount and the method
    * returns true.
    *
    * If the balance of the receiver is not equal to or greater than the argument
    * anAmount, the method simply returns false.
    */
   public boolean debit(double anAmount)
   {
      if (this.getBalance() >= anAmount)
      {
         this.setBalance(this.getBalance() - anAmount);
         return true;
      }
      else
      {
         return false;
      }
   }

   /**
    * If the balance of the receiver is equal to or greater than the argument anAmount,
    * the balance of the receiver is debited by the argument anAmount. The argument
    * toAccount is then credited by the argument anAmount and the method returns true.
    *
    * If the balance of the receiver is not equal to or greater than the argument
    * anAmount, the method simply returns false.
    */
   public boolean transfer(Account toAccount, double anAmount)
   {
      if (this.debit(anAmount))
      {
         toAccount.credit(anAmount);
         return true;
      }
      else
      {
         return false;
      }
   }

   /** 
    * Returns true if receiver is equivalent to (has the same 
    * state as) the argument anAccount, false otherwise. 
    */
   public boolean equals(Account anAccount)
   {
      return this.getBalance() == anAccount.getBalance() 
      && this.getNumber().equals(anAccount.getNumber()) 
      && this.getHolder().equals(anAccount.getHolder());
   }
}
