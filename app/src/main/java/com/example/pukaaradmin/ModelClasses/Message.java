
package com.example.pukaaradmin.ModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Message {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("reciever_id")
    @Expose
    private Integer recieverId;
    @SerializedName("messages")
    @Expose
    private Messages messages;
    @SerializedName("receiver")
    @Expose
    private Receiver receiver;
    @SerializedName("sender")
    @Expose
    private Sender sender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Integer recieverId) {
        this.recieverId = recieverId;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

}
