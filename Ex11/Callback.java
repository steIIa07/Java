import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface Callback extends Remote {
   public String speakJapanese() throws RemoteException;
   public String speakEnglish() throws RemoteException;
   public String greeting(String s) throws RemoteException;
   public String thanks(String s) throws RemoteException;
   public String sayThanksJapanese() throws RemoteException;
   public String sayThanksEnglish() throws RemoteException;
} 