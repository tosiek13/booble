package cepak.antoni.booble.jrs.model;

public class ClientMessage {
    private String messageType;
    private int xCenter;
    private int yCenter;
    private int radius;
    private String info;
    private String nick;
    private String password;
    private int playersAmount;
    private String roomId;

    
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getPlayersAmount() {
        return playersAmount;
    }

    public void setPlayersAmount(int playersAmount) {
        this.playersAmount = playersAmount;
    }
}