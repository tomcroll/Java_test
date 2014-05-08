
// Create new Management Server object
ManagementServer ms = new ManagementServer();
// Add test clients to server
ms.addTestClients();
// Print map - this shows test clients
ms.printMap();
// printMapValue shows all elemets of the map value (Set<String>) if present
ms.printMapValue("prod1");
// otherwise alerts that the map key does not exist and so has no values
ms.printMapValue("dfasd");


// Create a Set<String> to use as a valid paramater to the addMapEntry() method
Set<String> attributes = new HashSet<>();
       attributes.add("Frank");
       attributes.add("DB2");
       attributes.add("10.10.10.2");
       attributes.add("Prod");
 
// add map entry using name prod1 and Set<String> attributes. This should show a new entry in the map
ms.addMapEntry("prod1", attributes);

// new entry shown
ms.printMap();
// Test map for all keys containing attribute "Dev". Should return
// Server test1 contains attribute Dev
// [test1]
ms.selectKeys("Dev");
// Add value to test1 map key
ms.addValue("test1","AIX");
// Further tests on Map object
ms.selectKeys("Dev");
ms.selectKeys("AIX");
// Output
Server test1 contains attribute Dev
Server test1 contains attribute AIX
[test1]

// Test delete method
// Should remove key=values for test1
ms.deleteValue("test1","AIX");
//
ms.selectKeys("Dev");
// Output
Server test1 contains attribute Dev
[test1]
ms.selectKeys("AIX");
// Output
[] // Empty set. If I'd had time I would have coded this to return a useful message or throw an 
exception using the isEmpty() method
