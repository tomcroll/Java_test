import java.util.*;
import ou.*;
/**
 * The class ManagementServer defines a Server with the characteristics of a Management Server.
 *
 * @author Tom Croll
 * @version 2.0
 */

public class ManagementServer extends Server
{
   private Map<String, Set<String>> serverMap;
   private Set<String> attributes;
    
   /**
    * Constructor for objects of class Server which instatiates the variables
    * for a management server, initialising the management server to serverType management
    * and hostName master.
    */
   public ManagementServer()
   {
      super("management", "master", "");
      this.serverMap = new HashMap<>();
      this.attributes = new HashSet<>();
   }

   /* instance methods */    

   /**
    * Populates Map with test data
    */
   public void addTestClients()
   {
       attributes.add("Tom");
       attributes.add("Oracle");
       attributes.add("10.10.10.1");
       attributes.add("Dev");
       serverMap.put("test1", attributes);
       
       // Creates new HashSet to avoid mergeing with first HashSet
       attributes = new HashSet<>();
       attributes.add("Craig");
       attributes.add("DB2");
       attributes.add("10.10.10.2");
       attributes.add("Prod");
       serverMap.put("prod1", attributes);      
   }

   /**
    * Iterates over the map to print out a meaningful textual representation of its contents.
    * @param
    * @return
    */
   public void printMap()
   {
      for (String eachServer: serverMap.keySet())
      {
          attributes = serverMap.get(eachServer);
          System.out.println(eachServer + " has the following attributes:");
          for (String eachAttribute: attributes)
          {
              System.out.println("------> " + eachAttribute);
            }
        }
   }
   
   
   /**
    * If the argument is a key in the map, prints a meaningful textual representation of its 
    * associated value, otherwise displays a dialogue box announcing that the key is not present.
    * @param String aKey must be a valid key
    * @return
    */
   public void printMapValue(String aKey)
   {
      if (serverMap.containsKey(aKey))
      {
          attributes = serverMap.get(aKey);
          System.out.println(aKey + " has the follwowing attributes");
          for (String eachAttribute: attributes)
          {
              System.out.println("------> " + eachAttribute);
            }
        } 
        else
        {
            OUDialog.alert("Key " + aKey + " not present in server map");
        }
        
    }
       
   /**
    * Adds the key and value given as arguments to the map, checking first to see if the key
    * already exists and giving the user the option of overwriting the existing value for that key,
    * or doing nothing.
    * @param String aKey, Set<String> aSet
    * @return
    */
   public void addMapEntry(String aKey, Set<String> aSet)
   {
       if (serverMap.containsKey(aKey))
       {
           if (OUDialog.confirm("Key " + aKey + "already exists. Do you wish to overwrite?"))
           {
             serverMap.put(aKey, aSet);
            }
        }
        else
        {
            serverMap.put(aKey, aSet);
        }
    }
    
   /**
     * Returns a collection of all the keys which do not match the input string aKey
     * @param String aKey
     * @return Set<String> selectServers
     */
   public Set<String> selectKeys(String aValue)
   {
        Set<String> selectServers = new HashSet<>();
        
        for (String eachServer: serverMap.keySet())
        {
            attributes = serverMap.get(eachServer);
            if (attributes.contains(aValue))
            {
                    selectServers.add(eachServer);
                    System.out.println("Server " + eachServer + " contains attribute " + aValue);
            }
        }
        return selectServers;
   }
   
   /**
    * Adds a new value to a collection of values for a particular key. You can assume that the key 
    * exists in the map.
    * @param String aKey, String aValue
    * @return void
    */
   public void addValue(String aKey, String aValue)
   {
       /** Create copy of serverMap to modify in case we later decided to perform
        * a destructive operation
        */
       Map<String, Set<String>> updatedMap = new HashMap<>(serverMap);
       /** Extract the corresponding set from the Map and update */
       Set<String> updatedValues = new HashSet<>(serverMap.get(aKey));
       updatedValues.add(aValue);
       
       serverMap.put(aKey, updatedValues);
    }
       
   /**
    * Deletes a particular value from a collection of values for a particular key. You can assume
    * that both the key and the value exist in the map.
    * @param StringaKey, String aValue
    * @return void
    */
   public void deleteValue(String aKey, String aValue)
   {
       /** Create copy of serverMap to modify in case we later decided to perform
        * a destructive operation
        */
       Map<String, Set<String>> updatedMap = new HashMap<>(serverMap);
       /** Extract the corresponding set from the Map and update */
       Set<String> updatedValues = new HashSet<>(serverMap.get(aKey));
       updatedValues.remove(aValue);
       
       serverMap.put(aKey, updatedValues);
    }
   
}
