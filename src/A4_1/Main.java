package A4_1;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;

public class Main {

    public static SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();

    public static void main(String[] args) {
        get("https://www.bundestag.de/presse");
    }

    public static void get(String _url) {
        String host;
        String path;
        try {
            URL url = new URL(_url);
            host = url.getHost();
            path = url.getPath();

            SSLSocket socket = (SSLSocket) factory.createSocket(host, 443);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.write("GET " + path + " HTTP/1.1\nHost: " + host + "\n\n");
            writer.flush();

            String text = reader.readLine();

            while(text != null) {
                System.out.println(text);
                text = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
