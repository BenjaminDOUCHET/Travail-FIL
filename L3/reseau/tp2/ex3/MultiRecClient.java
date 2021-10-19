package ex3;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.io.IOException;
import java.lang.String;
import java.net.MulticastSocket;
import java.util.HashMap;

public class MultiRecClient extends  Thread{
    protected MulticastSocket socket ;
    protected InetAddress addr ;
    protected HashMap<String,String> names;

    /**
     * constructeur de client reception 
     * @param address l'adresse d'abonnement 
     * @param port le port de création du socket
     * @throws IOException
    */
    public MultiRecClient(final String address , final int port) throws IOException{
        super();
        this.socket = new MulticastSocket(port);
        this.addr = InetAddress.getByName(address);
        this.names = new HashMap<String,String>();
        //on mémorise sa propre adresse pour éviter une usurpation d'identité
        this.names.put("/"+InetAddress.getLocalHost().getHostAddress().toString(), "Moi");

    }

    public void run(){
        // on déclare les variables
        byte[] msg ; 
        DatagramPacket packet;

        // on abonne le socket
        try {
            this.socket.joinGroup(this.addr);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        // on démarre la boucle de reception
        while(true){
            msg = new byte[1024];
            packet = new DatagramPacket(msg, msg.length);
            try {
                ///on reçois le msg 
                this.socket.receive(packet);
                //on regarde si on a deja l'émetteur dans nos contacts
                 if(!this.names.containsKey(packet.getAddress().toString())){
                    // comme on ne l'a pas on l'enregistre
                    this.names.put(packet.getAddress().toString(), RandomNameGenerator.generate());
                    }
                if(!this.names.get( packet.getAddress().toString()).equals("Moi")){
                System.out.println(this.names.get( packet.getAddress().toString()) +" send you:");
                System.out.println(new String(packet.getData()));
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

    }
}