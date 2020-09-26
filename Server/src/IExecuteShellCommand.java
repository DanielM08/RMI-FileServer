import java.rmi.*;

public interface IExecuteShellCommand extends Remote{
    public String executeCommand(String command) throws RemoteException;
}
