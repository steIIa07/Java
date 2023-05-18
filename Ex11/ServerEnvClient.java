import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerEnvClient {
    public static void main(String args[]) {
	String[] infos = new String[2];
        ServerEnv obj = null;
        try {
	    obj = (ServerEnv)Naming.lookup("//localhost:4321/ServerEnv");
            infos = obj.getInfo(); 
        } catch (Exception e) { 
            System.out.println("ServerEnvClient exception: " + e.getMessage()); 
            e.printStackTrace(); 
        }
        // logining server and OS should be shown
        System.out.println("Server Env: OS of " + infos[0] + " is " + infos[1] + "." );
    }
}
