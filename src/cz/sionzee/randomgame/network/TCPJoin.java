package cz.sionzee.randomgame.network;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class TCPJoin {

    String clientToken;
    Socket socket;
    OutputStream output;
    InputStream input;

    public TCPJoin(String ip) {

        try {
            socket = new Socket(ip, 25000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            output = socket.getOutputStream();
            input = socket.getInputStream();
            output.write(TCPContants.ASK_FOR_TOKEN);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader ioRead = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(ioRead);
        try {
            clientToken = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
