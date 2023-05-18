import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class ServerEnvImpl extends UnicastRemoteObject implements ServerEnv{

    protected ServerEnvImpl() throws RemoteException {
        super();
    }

    @Override
    public Info getInfo() throws RemoteException {
        String server = System.getenv("HOSTNAME");
        String os = System.getProperty("os.name");
        return new Info(server, os);
    }
    public static void main(String args[]) { 

        // Create and install a security manager 
        if (System.getSecurityManager() == null) { 
	    System.setSecurityManager(new SecurityManager()); 
        } 
        try { 
	   ServerEnvImpl obj = new ServerEnvImpl();
	   Naming.rebind("//localhost:4321/ServerEnv", obj); 

	    System.out.println("ServerEnv Server bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("ServerEnvImpl err: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
