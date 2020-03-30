package A3_1;

import java.io.*;
import java.net.Socket;

public class TimeServiceClient {

    private BufferedReader reader;
    private BufferedWriter writer;
    private String response;
    private Socket socket;

    public TimeServiceClient(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String dateFromServer() {
        try {
            reader.readLine(); //Skip line "time service"
            this.writer.write("date\n");
            this.writer.flush();
            while ((this.response = this.reader.readLine()) != null) {
                return response;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "FAIL";
    }

    public String timeFromServer() {
        try {
            this.writer.write("time\n");
            this.writer.flush();
            while ((this.response = this.reader.readLine()) != null) {
                return response;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "FAIL";
    }

    public void closeService() throws IOException {
        this.writer.write("end\n");
        this.writer.flush();
        this.socket.close();
    }
}
