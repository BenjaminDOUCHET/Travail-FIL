package ex3;

import java.io.IOException;
import java.lang.String;


public class ClientTest {
    public static void main(String[] args) throws  IOException {
        Thread sender = new MultiSendClient("224.0.0.1", 7654);
        Thread receiver = new MultiRecClient("224.0.0.1", 7654);

        sender.start();;
        receiver.start();
	}
}