import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Command extends UnicastRemoteObject implements ICommand {

    public static final String EOL = System.getProperty("line.separator");

    protected Command(String s) throws RemoteException {
        File storageDir = new File (s);
        storageDir.mkdir();
    }

    public String[] listFiles(String dirPath) throws RemoteException {
        File f = new File(dirPath);
        return f.list();
    }

    public boolean createDirectory(String dirName) throws RemoteException {
        File f = new File(dirName);
        return f.mkdir();
    }

    public boolean createFile(String fileName) throws IOException, RemoteException {
        File f = new File(fileName);
        return f.createNewFile();
    }

    public String showFileContent(String filePath) throws IOException, RemoteException {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String nextLine = "";
            StringBuilder sb = new StringBuilder();
            while ((nextLine = br.readLine()) != null) {
                sb.append(nextLine);
                sb.append(EOL);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) br.close();
            if (fr != null) fr.close();
        }
        return "";
    }

    public boolean moveFile(String filePath, String fileDestiny) throws RemoteException {
        File f = new File(filePath);

        File d = new File(fileDestiny);

        return f.renameTo(d);
    }

    public boolean removeDirectoryOrFile(String fileOrDirName) throws RemoteException {
        File f = new File(fileOrDirName);
        return f.delete();
    }

    @Override
    public String printWorkingDirectory() throws RemoteException {
        Paths.get(".").toAbsolutePath().normalize().toString();
        return System.getProperty("user.dir");
    }

    @Override
    public boolean changeDirectory(String path) throws RemoteException {
        String currentDirectory = System.getProperty("user.dir");
        if (!path.startsWith("/"))
            path = currentDirectory + "/" + path;
        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("Caminho inválido");
            return false;
        }
        System.out.println(path);
        System.out.println("Mudou o caminho");
        System.setProperty("user.dir", path);
        return true;
    }
}
