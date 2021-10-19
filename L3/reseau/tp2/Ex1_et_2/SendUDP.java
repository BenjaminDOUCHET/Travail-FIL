package Ex1_et_2;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.io.IOException;
import java.lang.String;
public class SendUDP {
	
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		DatagramSocket sends = new DatagramSocket();
		InetAddress addr = InetAddress.getByName(args[0]);
		int port = Integer.parseInt(args[1]);
		String msg = args[2];
		DatagramPacket sendp = new DatagramPacket(msg.getBytes(), msg.length(),addr,port);
		sends.send(sendp);
		sends.close();
		
	}

}
