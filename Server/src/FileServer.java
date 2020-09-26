import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
    public static void main (String[] argv) {
        try {
            Registry registry = LocateRegistry
                    .createRegistry(1099);

            ExecuteShellCommand obj = new ExecuteShellCommand();
            Naming.rebind("Command", obj);

            System.out.println( registry.list()[0]);
            System.out.println("Ligado no registro");

            System.out.println("File Server is ready.");
        }catch (Exception e) {
            System.out.println("File Server failed: " + e);
        }
    }
}
