import java.util.*;
import java.io.*;
import java.net.*;
import java.util.function.Consumer;


public class Server{

    public Consumer<Socket>getConsumer(){
  // OVERIDDEN IMPLEMENTATION
//        return new Consumer<Socket>()
//        {   @Override
//            public void accept(Socket clientSocket){
//                try {
//                    PrintWriter toClient= new PrintWriter(clientSocket.getOutputStream());
//                    toClient.println("Hello from the Server !!");
//                    toClient.close();
//                    clientSocket.close();
//
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//
//            }
//        };
  //MANUAL IMPLEMENATATION
        return (clientSocket)->{
            try {
                PrintWriter toClient= new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the Server !!");
                toClient.close();
                clientSocket.close();

            }catch(IOException e){
                e.printStackTrace();
            }
        };


    }




    public static void main(String[] args){
        int port = 8010;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
