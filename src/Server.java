import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalTime;

public class Server {
    final static int Port = 4445;
    public static void main(String[] args) throws Exception {
        while(true) {
        try(ServerSocket serverSocket = new ServerSocket(Port);){
            Socket server = serverSocket.accept();
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Time Now is : " + LocalTime.now().toString());
            server.close();

        }catch(SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
        }catch(IOException e) {
            e.printStackTrace();
            break;
        }



        }
    }
}
