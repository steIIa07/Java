import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerEnvClient {
    public static void main(String args[]) {
        Info info = null;        
        ServerEnv obj = null; 
    
        try { 
                obj = (ServerEnv)Naming.lookup("//" + "/HelloServer");
                info = obj.getInfo(); 
        } catch (Exception e) { 
            System.out.println("HelloClient exception: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
        System.out.println(info.toString());
    }
}
