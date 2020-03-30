package A2_1;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static Clock clock = new Clock();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(75);
        Socket socket;
        String input;
        do {
            try {
                socket = serverSocket.accept();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer.write("time service\n");
                writer.flush();
                while (true) {
                    input = reader.readLine();
                    if (input != null) {
                        switch (input) {
                            case "date":
                                writer.write(Clock.date() + "\n");
                                writer.flush();
                                break;
                            case "time":
                                writer.write(Clock.time() + "\n");
                                writer.flush();
                                break;
                            default:
                                socket.close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}


