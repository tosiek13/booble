// *******************************************
// * Copyright (c) CRIF - All Right Reserved *
// *******************************************
package cepak.antoni.booble.jrs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint.Basic;

/**
 * @author pl041antcepa, 20 wrz 2017
 * CRIF IT Solutions Poland
 */
public class MockBasic implements Basic {

    @Override
    public void setBatchingAllowed(boolean allowed) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean getBatchingAllowed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void flushBatch() throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendText(String text) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendBinary(ByteBuffer data) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendText(String partialMessage, boolean isLast) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendBinary(ByteBuffer partialByte, boolean isLast) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public OutputStream getSendStream() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Writer getSendWriter() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sendObject(Object data) throws IOException, EncodeException {
    }

}
