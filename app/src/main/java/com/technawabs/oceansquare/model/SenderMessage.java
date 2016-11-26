package com.technawabs.oceansquare.model;

/**
 * Created by piyush.aggarwal on 26-11-2016.
 */

public class SenderMessage {
    String senderMessage;
    String senderImage;

    public SenderMessage(String senderMessage, String senderImage) {
        this.senderMessage = senderMessage;
        this.senderImage = senderImage;
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(String senderMessage) {
        this.senderMessage = senderMessage;
    }

    public String getSenderImage() {
        return senderImage;
    }

    public void setSenderImage(String senderImage) {
        this.senderImage = senderImage;
    }

}
