package ex3;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.String;
import java.net.MulticastSocket;
import java.io.InputStreamReader;




public class MultiSendClient extends Thread{
    protected MulticastSocket socket ;
    protected InetAddress addr;
    protected BufferedReader buffer;
    private static final int PORT = 7654;

    /**
     * construcct de la classe d'émission
     * @param address l'adresse d'abonnement
     * @param port le port sur lequel emettre le message 
     * @throws IOException
     */
    public MultiSendClient(String address , int port) throws IOException{
        super();
        this.socket = new MulticastSocket(port);
        this.addr = InetAddress.getByName(address);
        this.buffer = new BufferedReader(new InputStreamReader(System.in));
    }


    public void run(){
        // on déclare les variables 
        String msg;
        DatagramPacket packet;

        while(true){
            try {
                //on lis le buffer
                msg = buffer.readLine();
                // on prépare le packet
                packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, this.addr, PORT);
                //on envoie le packet
                socket.send((packet));
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}