import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int portNumber = 8888;

        try {
            Socket socket = new Socket(serverAddress, portNumber);
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(), true);

            // Sending request to the server
            String request = "apple"; // Change keyword and options as needed
            outputToServer.println(request);

            // Receiving response from the server
            String response = inputFromServer.readLine();
            System.out.println("Received from server: " + response);

            inputFromServer.close();
            outputToServer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
