package cepak.antoni.booble.jrs.coders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import cepak.antoni.booble.jrs.model.ClientMessage;
import cepak.antoni.booble.jrs.model.ServerMessage;
import com.google.gson.Gson;

public class ClientMessageEncoder implements Encoder.Text<ClientMessage> {

    private static Gson gson = new Gson();

    @Override
    public String encode(ClientMessage message) throws EncodeException {
        return gson.toJson(message);
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