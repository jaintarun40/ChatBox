package com.example.tarun.chatbox;

/**
 * Created by varun on 30/3/17.
 */

public class Message {
    private String messageText;
    private String authorName;
    private String photoUrl;

    public Message() {

    }

    public Message(String messageText, String authorName, String photoUrl) {
        this.messageText = messageText;
        this.authorName = authorName;
        this.photoUrl = photoUrl;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
