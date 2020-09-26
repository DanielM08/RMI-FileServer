import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.*;

public interface ICommand extends Remote{
    public String[] listFiles(String dirPath) throws RemoteException;
    public boolean createDirectory(String dirName) throws RemoteException;
    public boolean createFile(String fileName) throws IOException;
    public String showFileContent(String filePath) throws IOException;
    public boolean moveFile(String filePath, String fileDestiny) throws RemoteException;
    public boolean removeDirectoryOrFile(String fileOrDirName) throws RemoteException;
    public String printWorkingDirectory() throws RemoteException;
    public boolean changeDirectory(String s) throws RemoteException;
}
