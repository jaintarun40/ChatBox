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

    public Message() {
    }

    public Message(String messageText, String authorName, String photoUrl) {
        this.messageText = messageText;
        this.authorName = authorName;
        this.photoUrl = photoUrl;
        this.messageDate = new Date();
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
}
