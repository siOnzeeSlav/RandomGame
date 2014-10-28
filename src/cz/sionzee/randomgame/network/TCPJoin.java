package cz.sionzee.randomgame.network;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by sionzee on 28. 10. 2014.
 */
public class TCPJoin {

    String clientToken;
    Socket socket;

    public TCPJoin(String ip) {

        try {
            socket = new Socket(ip, 25000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(socket)

    }
}
