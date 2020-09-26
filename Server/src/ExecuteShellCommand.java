import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ExecuteShellCommand extends UnicastRemoteObject implements IExecuteShellCommand {

    public ExecuteShellCommand() throws RemoteException { super(); }

    public String executeCommand(String command) {

        if (command.trim().equals("ls")) {
            StringBuffer output = new StringBuffer();
            Process p;
            try {
                p = Runtime.getRuntime().exec(command);
                p.waitFor();
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return output.toString();
        }
        else {
            return "Invalid Command\n";
        }
    }

    @Override
    public String[] listFiles(String serverPath) throws RemoteException {
        return new String[0];
    }

    @Override
    public String[] listFiles() throws RemoteException {
        return new String[0];
    }

    @Override
    public boolean remove(String serverPath) throws RemoteException {
        return false;
    }

    @Override
    public boolean createDirectory(String serverPath) throws RemoteException {
        return false;
    }

    @Override
    public boolean createFile(String serverPath) throws RemoteException {
        return false;
    }

    @Override
    public String printWorkingDirectory() throws RemoteException {
        return null;
    }
}
