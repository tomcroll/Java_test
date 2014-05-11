import java.util.*;
import ou.*;
/**
 * Class ClientServer has many of the same properties as a server, however only holds
 * a reference to the ManagementServer from whom it receives software and configuration
 * updates.
 * 
 * @author Tom Croll 
 * @version 1.0
 */
public class ClientServer extends Server
{
    private String builder;
    private String application;
    private String IP;
    private String environment;

    /**
     * Constructor for objects of class ClientServer
     */
    public ClientServer()
    {
        super("client", "application");
        this.builder = "";
        this.application = "";
        this.IP = "";
        this.environment = "";
    }
    
    /**
     * Constructor for objects of class ClientServer
     */
    public ClientServer(String builderName, String anApp, String anIP, String anEnv)
    {
        this.builder = builderName;
        this.application = anApp;
        this.IP = anIP;
        this.environment = anEnv;
    }

    /**
     * An example method which would return the builder attribute of the server. This would
     * be useful for support of a server and allocation of responsibility
     * 
     * @param  None
     * @return String Name of the person who built the server 
     */
    public String getBuilder()
    {
        return this.builder;
    }
}
