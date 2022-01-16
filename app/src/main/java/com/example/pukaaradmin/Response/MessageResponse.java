package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

public class MessageResponse {

    @SerializedName("data")
    public FirstDatum  Fdata = null;

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

    public FirstDatum getFdata() {
        return Fdata;
    }

    public void setFdata(FirstDatum fdata) {
        Fdata = fdata;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("success")
    public Boolean success = false;
    @SerializedName("message")
    public String message = "";
}
