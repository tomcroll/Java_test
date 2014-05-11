import java.util.*;
import ou.*;
/**
 * The class ManagementServer2 defines a Server with the characteristics of a 
 * Management Server which would hold objects of type ClientServer.
 * Unfinished
 * @author Tom Croll
 * @version 2.0
 */

public class ManagementServer2 extends Server
{
   private Map<String, Set<ClientServer>> serverMap;
   private Set<ClientServer> clients;
    
   /**
    * Constructor for objects of class Server which instatiates the variables
    * for a management server
    */
   public ManagementServer2()
   {
      super("management2", "master");
      this.serverMap = new HashMap<>();
      this.clients = new HashSet<>();
   }

   /* instance methods */    

   /**
    * Populates Map with test data. This time, collections of server objects are create
    * and grouped into HashSets of clients - in this example servers are grouped into 
    * subnets to model IP address ranges / groups of clients. This would be useful for
    * allocating group operations and permission rules etc.
    */
   public void addTestClients()
   {
       
       ClientServer cs1 = new ClientServer("Tom","Oracle","10.10.10.1","Dev");
       ClientServer cs2 = new ClientServer("Craig","DB2","10.10.10.2","Dev");
       ClientServer cs3 = new ClientServer("Steve","WebSphere","10.10.10.3","Dev");
       
       clients.add(cs1);
       clients.add(cs2);
       clients.add(cs3);

       serverMap.put("Subnet1_Dev", clients);
       
       // Creates new HashSet to avoid mergeing with first HashSet
       clients = new HashSet<>();
       ClientServer cs4 = new ClientServer("Tom","Oracle","192.168.0.1","Prod");
       ClientServer cs5 = new ClientServer("Craig","DB2","192.168.0.2","Prod");
       ClientServer cs6 = new ClientServer("Steve","WebSphere","192.168.0.3","Prod");
       
       clients.add(cs4);
       clients.add(cs5);
       clients.add(cs6);

       serverMap.put("Subnet2_Prod", clients);      
   }

   /**
    * Iterates over the map to print out a meaningful textual representation of its contents.
    * @param
    * @return
    * 
    * public void printMap()
    */

}
