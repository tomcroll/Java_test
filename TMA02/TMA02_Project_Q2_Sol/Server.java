import java.util.*;
import ou.*;
/**
 * The abstract class Server forms the basis of all Servers.
 *
 * @author Tom Croll
 * @version 1.0
 */
public abstract class Server
{
   /* private class variable declared to ensure all servers have a unique identifier
    * This will be used to track instances in a CMDB and ensure hostnames and
    * IP addresses do not conflict. The implementation of these functions is
    * however, outside the scope of this assignment
    */ 
   private static int nextNode = 1;
   /* instance variables */
   private String serverType;
   private String hostName;
   private String IP;
   private int nodeNumber;
   
   /**
    * Constructor for objects of the abstract class Server.
    */
   public Server()
   {
      this.serverType = "";
      this.hostName = "";
      this.IP = "";
      
      this.nodeNumber = Server.nextNode;
      Server.nextNode = Server.nextNode +1;
   }
   
   /**
    * Constructor for objects of the abstract class Server.
    */
    
   public Server(String aName, String aType, String anIP)
   {
      this.serverType = aType;
      this.hostName = aName;
      this.IP = anIP;
      this.nodeNumber = Server.nextNode;
      Server.nextNode = Server.nextNode +1;
   }

   /* instance methods */    

   /**
    * Returns the Type of the receiver.
    */
   public String getServerType()
   {
      return this.serverType;
   }

   /**
    * Sets the Server Type of the receiver to the value of the argument aType.
    */
   public void setServerType (String aType)
   {
      this.serverType = aType;
   }

   /**
    * Sets the Type of the receiver to the argument's Type.
    */
   public void sameTypeAs(Server aServer)
   {
      this.setServerType(aServer.getServerType());
   }

   /**
    * Returns the hostname of the receiver.
    */
   public String getHostName()
   {
      return this.hostName;
   }

   /**
    * Sets the type of the receiver to master.
    */
   public void management()
   {
      this.setServerType("management");
   }

   /**
    * Sets the type of the receiver to master.
    */
   public void client()
   {
      this.setServerType("client");
   }

   /**
    * Returns a string representation of the receiver.
    */
   @Override 
   public String toString()
   {
      return "An instance of class " + this.getClass().getName() 
      + ": hostname " + this.getHostName() 
      + ", server type " + this.getServerType();
   }
}
