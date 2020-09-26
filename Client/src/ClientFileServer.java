import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientFileServer {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        IExecuteShellCommand obj;
        try {
            System.out.println("Conecting to server...");
            Registry registry = LocateRegistry
                    .getRegistry("localhost",1099);

            obj = (IExecuteShellCommand) registry.lookup("Command");
            // Main Loop
            String[] input = {""};
            String cmd = "";
            System.out.println("Welcome to remote file manager");
            while (!cmd.equals("exit"))
            {
                System.out.print(">>> ");
                input = sc.nextLine().split(" ");
                cmd = input[0];
                if (cmd.equals("ls"))
                {
                    //String result = obj.executeCommand("ls");
                    String []files = obj.listFiles();
                    for (String file : files ) {
                        System.out.println(file);
                    }
                    //System.out.println(result);
                }
                else if (cmd.equals("rm"))
                {
                    try {
                        obj.remove(input[1]);
                    }
                    catch (Exception e){
                        System.out.println("[Error on arguments]");
                    }
                }
                else if (cmd.equals("mkdir"))
                {
                    try {
                        obj.createDirectory(input[1]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("[Error on arguments]");
                    }
                }
                else if (cmd.equals("touch"))
                {
                    try {
                        obj.createFile(input[1]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("[Error on arguments]");
                    }
                }
                //String printWorkingDirectory() throws RemoteException;
                else if (cmd.equals("pwd"))
                {
                    String workingDir = obj.printWorkingDirectory();
                    System.out.println(workingDir);
                }
                else
                {
                    System.out.println("[Invalid Command]");
                }
            }

        }catch (Exception e) {
            System.out.println("ClientFileClient exception: " + e);
        }
    }
}
