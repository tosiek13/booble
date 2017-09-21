package cepak.antoni.booble.jrs.coders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import cepak.antoni.booble.jrs.model.ServerMessage;
import com.google.gson.Gson;

public class ServerMessageDecoder implements Decoder.Text<ServerMessage> {
 
    private static Gson gson = new Gson();
 
    @Override
    public ServerMessage decode(String s) throws DecodeException {
        return gson.fromJson(s, ServerMessage.class);
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