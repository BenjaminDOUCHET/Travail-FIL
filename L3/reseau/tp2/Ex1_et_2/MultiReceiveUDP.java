package Ex1_et_2;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.io.IOException;
import java.lang.String;
import java.net.MulticastSocket;

public class MultiReceiveUDP {
	
	
	public static void main(String[] args) throws IOException {
		MulticastSocket soc = new MulticastSocket(7654);
		soc.joinGroup(InetAddress.getByName("224.0.0.1"));
		DatagramPacket socp = new DatagramPacket(new byte[1024],1024);
		
		
		while(true){
		soc.receive(socp);
		String msg = new String(socp.getData());
		System.out.println("nouveau message : "); 
		System.out.println(msg);
		}
	}
}
