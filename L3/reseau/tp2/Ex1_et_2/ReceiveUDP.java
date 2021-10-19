package Ex1_et_2;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.lang.String;


public class ReceiveUDP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		DatagramSocket rec = new DatagramSocket(Integer.parseInt(args[0]));
		byte[] bytes = new byte[512] ;
		DatagramPacket recp = new DatagramPacket(bytes, 512);
		rec.receive(recp);
		String data = new String(recp.getData());
		System.out.println(data);
		rec.close();
	}

}