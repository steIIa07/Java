import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class ServerEnvImpl extends UnicastRemoteObject implements ServerEnv{

    protected ServerEnvImpl() throws RemoteException {
        super();
    }

    @Override
    public String[] getInfo() throws RemoteException {
	String[] infos = new String[2];
	infos[0] = System.getenv("HOSTNAME");
        infos[1] = System.getProperty("os.name");
        return infos;
    }
    public static void main(String args[]) { 
        // // Create and install a security manager 
        // if (System.getSecurityManager() == null) { 
	    // System.setSecurityManager(new SecurityManager()); 
        // } 
        try { 
	   ServerEnvImpl obj = new ServerEnvImpl();
	   // Naming.rebind("//localhost:4321/ServerEnv", obj); 
	   Naming.rebind("ServerEnv", obj);
	    System.out.println("ServerEnv Server bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("ServerEnvImpl err: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
