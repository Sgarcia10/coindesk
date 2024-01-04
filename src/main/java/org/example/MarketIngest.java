package org.example;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class MarketIngest  extends WebSocketClient {

    public MarketIngest(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connection opened");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("Error occurred: ");
        ex.printStackTrace();
    }

    public void subscribeToChannel(String channel) {
        System.out.println("Subscribed to channel: " + channel);
    }

    public void respondToHeartbeat(long messageId) {
        System.out.println("Heartbeat ACK sent for message ID: " + messageId);
    }

}
