package cz.sionzee.randomgame.network;

import cz.sionzee.randomgame.network.entity.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class TCPCreate {

    public static final HashMap<Socket, Client> clients = new HashMap<Socket, Client>();

    ServerSocket socket;
    public TCPCreate() {
        try {
            socket = new ServerSocket(25000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                Client c = new Client(this, socket.accept());
                clients.put(c.getSocket(), c);
                onClientConnect(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClientConnect(Client client) {
        System.out.println("+ client = [" + client.getSocket() + "]");
        Thread clientThread = new Thread(client);
        clientThread.start();
    }

    public void onClientDisconnect(Client client) {
        System.out.println("- client = [" + client.getSocket() + "]");
        clients.remove(client.getSocket());
        try {
            client.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String msg) {
        clients.values().stream().forEach(c -> {
            c.getOutput().println(msg);
            c.getOutput().flush();
        });
    }

}
