package com.example.tarun.chatbox;

import java.util.Date;
import java.util.UUID;

/**
 * Created by varun on 30/3/17.
 */

public class Message {
    private String messageText;
    private String authorName;
    private String photoUrl;
    private Date messageDate;
    private boolean sent;
    private String key;
    private String email;

    public Message() {
    }

    public Message(String messageText, String authorName, String photoUrl, String email) {
        this.messageText = messageText;
        this.authorName = authorName;
        this.photoUrl = photoUrl;
        this.messageDate = new Date();
        this.sent = false;
        this.key = "";
        this.email = email;
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

    public Date getMessageDate() {
        return messageDate;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
