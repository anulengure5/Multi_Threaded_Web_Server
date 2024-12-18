import java.util.*;
import java.io.*;
import java.net.*;


public class Client{

   public Runnable getRunnable() {
       return new Runnable() {
           @Override
           public void run() {
               int port = 8010;
               try {
                   InetAddress address = InetAddress.getByName("localhost");
                   Socket socket = new Socket(address, port);
                   try (
                       PrintWriter toServer = new PrintWriter(socket.getOutputStream());
                       BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                   ) {
                       toServer.println(" Client : Hi Server  !");
                       String line = fromServer.readLine();
                       System.out.println("Response from the server is : " + line);
                   }catch(IOException e)
                   {
                       e.printStackTrace();
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }

           }
       };

   }

    public static void main(String[] args){
        Client client=new Client();
        for(int i=0;i<100;i++)
        {
            try{
                Thread thread= new Thread (client.getRunnable());
                thread.start();
            }catch(Exception e)
            {
                return ;
            }
        }
    }
}