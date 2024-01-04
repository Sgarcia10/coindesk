package org.example;

import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;

public class CryptoComIngest extends MarketIngest {

    private static final String CHANNEL_BTCUSD_PERP = "BTCUSD-PERP";
    private static final String CRYPTO_STREAM_URL = "wss://stream.crypto.com/exchange/v1/market";

    public CryptoComIngest(String connectionUrl) throws Exception {
        super(new URI(connectionUrl));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        super.onOpen(handshakedata);
        subscribeToChannel(CHANNEL_BTCUSD_PERP);
    }

    @Override
    public void onMessage(String message) {
        super.onMessage(message);
        JSONObject jsonMessage = new JSONObject(message);

        if (jsonMessage.has("method")) {
            String method = jsonMessage.getString("method");

            if ("public/heartbeat".equals(method)) {
                long messageId = jsonMessage.getLong("id");
                respondToHeartbeat(messageId);
            } else if ("public/respond-heartbeat".equals(method)) {
                System.out.println("Received Heartbeat ACK from the server.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CryptoComIngest cryptoComIngest = new CryptoComIngest(CRYPTO_STREAM_URL);
        cryptoComIngest.connect();
    }
}
