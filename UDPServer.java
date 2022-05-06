import java.net.*;
import java.io.*;

public class UDPServer {
	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			while (true) {
				System.out.println("Working 1");
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				System.out.println("Working 2");
				aSocket.receive(request);
				System.out.println("Working 3");
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(),
						request.getPort());
				System.out.println("A Client has been visited...");
				aSocket.send(reply);
			}
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally

		{
			if (aSocket != null)
				aSocket.close();
		}
	}
}