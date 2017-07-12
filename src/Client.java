import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String serverName = "127.0.0.1";
        int port = 4445;
        try {
           Socket client = new Socket(serverName, port);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println( in.readUTF());
            client.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
