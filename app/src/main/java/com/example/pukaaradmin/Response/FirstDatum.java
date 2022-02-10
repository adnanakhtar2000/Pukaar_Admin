package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

public class FirstDatum {

        @SerializedName("sender_id")
        public int senderId = 0;

        @SerializedName("sender_name")
        public String senderName ="";

        @SerializedName("reciever_id")
        public int recieverId = 0;

        @SerializedName("content")
        public String content = "";

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        @SerializedName("created_at")
        public String created_at = "";

        @SerializedName("message_id")
        public String messageId = "";

    public FirstDatum(int senderId, String senderName, int recieverId, String content, String created_at, String messageId) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.recieverId = recieverId;
        this.content = content;
        this.created_at = created_at;
        this.messageId = messageId;
    }

    public int getSenderId() {
            return senderId;
        }

        public void setSenderId(int id) {
            this.senderId = id;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public int getRecieverId() {
            return recieverId;
        }

        public void setRecieverId(int recieverId) {
            this.recieverId = recieverId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }
    }


