package cepak.antoni.booble.jrs.coders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import cepak.antoni.booble.jrs.model.ServerMessage;
import cepak.antoni.booble.jrs.model.exp.CServerMessage;
import com.google.gson.Gson;

public class ServerMessageEncoder implements Encoder.Text<ServerMessage> {

    private static Gson gson = new Gson();

    @Override
    public String encode(ServerMessage message) throws EncodeException {
        CServerMessage response = message.export();
        String value = gson.toJson(response);
        return value;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}