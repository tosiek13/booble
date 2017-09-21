package cepak.antoni.booble.jrs.coders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import cepak.antoni.booble.jrs.model.exp.CServerMessage;
import com.google.gson.Gson;

public class CServerMessageEncoder implements Encoder.Text<CServerMessage> {

    private static Gson gson = new Gson();

    @Override
    public String encode(CServerMessage message) throws EncodeException {
        String value = gson.toJson(message);
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