import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.SecurityManager;

public class HelloImpl extends UnicastRemoteObject
    implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
	return "Hi! I am in local server and using port 4321!";
    }

    public static void main(String args[]) { 

        // Create and install a security manager 
        if (System.getSecurityManager() == null) { 
	    System.setSecurityManager(new SecurityManager()); 
        } 
        try { 
	    HelloImpl obj = new HelloImpl(); 
	    // Bind this object instance to the name "HelloServer" 
            // RMI uses 1099 as a default port
	    Naming.rebind("//localhost:4321/HelloServer", obj);
	    System.out.println("HelloServer bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("HelloImpl err: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
