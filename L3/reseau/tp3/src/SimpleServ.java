import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SimpleServ {



 public static void main(String[] args){
     try(ServerSocket socketServ = new ServerSocket(2021)){
     
     while(true){
        Socket tempSocket = socketServ.accept();

        // on crée la chanie de sortie : 
        OutputStream output = tempSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println("Bienvenue sur mon serveur et au revoir");
        
        //on referme le socket
        tempSocket.close();
     
    }
} catch (IOException ex){
    System.out.println(ex.getMessage());
    
}
 }
}