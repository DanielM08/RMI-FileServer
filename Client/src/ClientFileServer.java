import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientFileServer {
    public static void main (String[] args) {
        IExecuteShellCommand obj;
        try {
            Registry registry = LocateRegistry
                    .getRegistry("localhost",1099);

            obj = (IExecuteShellCommand) registry.lookup("Command");

            String result = obj.executeCommand("ls");
            System.out.println("Result is : "+result);

        }catch (Exception e) {
            System.out.println("ClientFileClient exception: " + e);
        }
    }
}
