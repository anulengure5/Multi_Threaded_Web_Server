import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;


public class Server{
    public void run() throws IOException
    {
        int port=8010;
        ServerSocket serverSocket=new ServerSocket(port);
        // mere laptop (localHost) me se ek port initialize
        serverSocket.setSoTimeout(10000);
        while(true)
        {
            try {
                System.out.println("Server is listening port " + port);
                Socket acceptedConnection = serverSocket.accept();
                System.out.println("Connection accepted from client "+ acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient=new PrintWriter(acceptedConnection.getOutputStream()); // printwriter converts written data to bits (0/1) format, data to be sent to client
                BufferedReader fromClient=new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream())); // Buffered Reader get bit data  from client and understands
                System.out.println("Client connected");

            toClient.println(" Hello Client !");
            toClient.close();
            fromClient.close();
            acceptedConnection.close();
                }catch(IOException e)
                 {
                   e.printStackTrace();
                 }


        }

    }

    public static void main(String[] args){

        Server server=new Server();

       try{
           server.run();
           }catch(Exception e){
           e.printStackTrace();
                       }


    }
}