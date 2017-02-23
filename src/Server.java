import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

public class Server implements Runnable {
	Thread t1;
	private ServerSocket server;
	private Socket client;
	private static Vector loginName;
	private static Vector loginSocket;
	private static Vector message;
	private PrintStream out;
	private BufferedReader in;
	private StringTokenizer msg;
	private String msg3 = "";

	public Server()

	{

		try {
			server = new ServerSocket(8001);
			loginName = new Vector();
			loginSocket = new Vector();
			message = new Vector();

			System.out.println(" Server Started.......");
			System.out
					.println("       ...............WELCOME TO THE SERVER..............        ");

			while (true) {
				client = server.accept();
				t1 = new Thread(this);
				t1.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void run() {

		// while(true)
		{
			try {

				in = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				String stringClient = in.readLine();

				msg = new StringTokenizer(stringClient, "#");
				String client_msg = msg.nextToken();

				if (client_msg.equals("Login")) {

					String usr = msg.nextToken();
					loginName.add(usr);
					loginSocket.add(client);
					System.out.println(client);
					String newusr = "New Login : " + usr;

					for (int i = 0; i < loginName.size(); i++) {
						newusr += "#" + (String) loginName.elementAt(i);
					}
					for (int j = 0; j < loginSocket.size(); j++) {
						client = (Socket) loginSocket.elementAt(j);
						if (client != null) {
							out = new PrintStream(client.getOutputStream());
							out.println(newusr);
						}
					}
				} else {
					message.add(client_msg);
					for (int i = 0; i < message.size(); i++) {
						msg3 += "#" + (String) message.elementAt(i);
					}
					out = new PrintStream(client.getOutputStream());
					out.println(msg3);
				}

				// out.flush();
				// in.close();
				// client.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		Server ser = new Server();
	}
}