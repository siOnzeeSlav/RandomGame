package cz.sionzee.randomgame.network.entity;

import cz.sionzee.randomgame.network.TCPCreate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class Client implements Runnable {

    Socket socket;
    PrintWriter output;
    BufferedReader input;
    TCPCreate server;
    String token;

    public Client(TCPCreate server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public BufferedReader getInput() {
        return input;
    }

    @Override
    public void run() {
        try {
            output = new PrintWriter(socket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                //TODO Client CODE
                if(output.checkError()) {
                    server.onClientDisconnect(this);
                    input.close();
                    output.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.onClientDisconnect(this);
        }

    }
}
