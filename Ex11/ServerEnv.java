import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerEnv {
    Info getInfo() throws RemoteException;
}
