import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IExecuteShellCommand extends Remote{
    public String executeCommand(String command) throws RemoteException;
    public String[] listFiles() throws RemoteException;
    public String[] listFiles(String serverPath) throws RemoteException;
    public boolean remove(String serverPath) throws RemoteException;
    public boolean createDirectory(String serverPath) throws RemoteException;
    public boolean createFile(String serverPath) throws RemoteException;
    public String printWorkingDirectory() throws RemoteException;
}
