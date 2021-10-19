package Ex1_et_2;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.lang.String;


public class MultiSendUDP {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket sends = new DatagramSocket();
		InetAddress addr = InetAddress.getByName("224.0.0.1");
		int port = 7654;
		String msg = args[0];
		DatagramPacket sendp = new DatagramPacket(msg.getBytes(), msg.length(),addr,port);
		sends.send(sendp);
		sends.close();
		
	}

}
