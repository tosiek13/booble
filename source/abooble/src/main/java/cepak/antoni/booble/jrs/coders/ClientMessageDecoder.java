package cepak.antoni.booble.jrs.coders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import cepak.antoni.booble.jrs.model.ClientMessage;
import com.google.gson.Gson;

public class ClientMessageDecoder implements Decoder.Text<ClientMessage> {
 
    private static Gson gson = new Gson();
 
    @Override
    public ClientMessage decode(String s) throws DecodeException {
        return gson.fromJson(s, ClientMessage.class);
    }
 
    @Override
    public boolean willDecode(String s) {
        return (s != null);
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