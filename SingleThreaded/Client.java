import java.util.*;
import java.io.*;
import java.net.*;
import java.net.InetAddress;

public class Client{

    public void run() throws UnknownHostException, IOException{
        int port=8010;
        InetAddress address=InetAddress.getByName("localhost");
        Socket socket =new Socket(address,port);
        PrintWriter toServer=new PrintWriter ( socket.getOutputStream());
        BufferedReader fromServer= new BufferedReader (new InputStreamReader(socket.getInputStream()))  ;
        toServer.println(" Client : Hi Server  !");
        String line= fromServer.readLine();
        System.out.println("Response from the server is : "+ line);
        toServer.close();
        fromServer.close();
        socket.close();

    }
    public static void main(String []args)
    {
        try {
            Client client =new Client();
            client.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}