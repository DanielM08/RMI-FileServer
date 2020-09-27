import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientFileServer {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ICommand obj;
        try {
            System.out.println("Conecting to server...");
            Registry registry = LocateRegistry
                    .getRegistry("localhost",1099);

            //obj = (IExecuteShellCommand) registry.lookup("Command");
            obj = (ICommand) registry.lookup("Command");
            // Main Loop
            String[] input = {""};
            String cmd = "";
            System.out.println("Welcome to remote file manager");
            while (!cmd.equals("exit"))
            {
                System.out.print(">>> ");
                input = sc.nextLine().split(" ");
                cmd = input[0];
                if (cmd.equals("mkdir"))
                {
                    try {
                        obj.createDirectory(input[1]);
                    }
                    catch (Exception e){
                        System.out.println("[Error on arguments]");
                    }
                }
                else if (cmd.equals("touch")){
                    try {
                        obj.createFile(input[1]);
                    }
                    catch (Exception e){
                        System.out.println("[Error on arguments]");
                    }
                }
                else if (cmd.equals("ls"))
                {
                    try {
                        String []files;
                        files = obj.listFiles(input[1]);
                        for (String file : files ) {
                            System.out.println(file);
                        }
                    }
                    catch (Exception e) {
                        System.out.println("[Error on arguments]");
                    }
                }
                else if (cmd.equals("rm"))
                {
                    try {
                        obj.removeDirectoryOrFile(input[1]);
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
                else if (cmd.equals("cat"))
                {
                    try {
                        String result = obj.showFileContent(input[1]);
                        System.out.println(result);
                    }
                    catch (Exception e){
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
                else if (cmd.equals("mv"))
                {
                    try {
                        boolean success = obj.moveFile(input[1], input[2]);
                        if (!success){
                            System.out.println("[Failed to move]");
                        }
                    }
                    catch (Exception e) {
                        System.out.println("[Error on arguments]");
                    }
                }
                else
                {
                    System.out.println("[Invalid Command]");
                }
            }

        }catch (Exception e) {
            System.out.println("ClientFileClient exception: ");
            e.printStackTrace();
        }
    }
}
