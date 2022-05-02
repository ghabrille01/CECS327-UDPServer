import java.net.*;
import java.io.*;

/*
* Ghabrille Ampo 017003517
* Justin Salazar 026083952
*/


public class EchoServer
{
	public static void main(String[] args){
		try{
			/*Create new socket*/
			ServerSocket sock = new ServerSocket(6013);
			/*wait for socket connection*/
			while (true) {
				Socket client = sock.accept();
				System.err.println("Client Connected");
				
				/*open io stream*/
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String echo;
				
				/*read incoming messages and swap keyword*/
				/*stop listening if receive "Client Closing" */
				while((echo = in.readLine())!= null){
					if(!echo.contains("Client Closing")){
						System.out.println(echo);
						echo = echo.replace("Client","Server");
						out.println(echo);
					}else{
						System.out.println(echo);
						out.println(echo);
						break;
					}
				}
				/*close the socket,io stream, and resume*/
				/*listening for connections*/
				out.close();
				in.close();
				client.close();
				System.out.println("Client Connection Closed");
			}
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
