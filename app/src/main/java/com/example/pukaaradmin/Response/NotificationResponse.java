package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

public class NotificationResponse {

   /* @SerializedName("data")
    public ArrayList<FirstDatum>  Fdata = null;*/

/*
    public class FirstDatum {
*/

        @SerializedName("id")
        public int id = 0;

        @SerializedName("sender_id")
        public int senderId = 0;

        @SerializedName("reciever_id")
        public int recieverId = 0;

        @SerializedName("data")
        public String data ="";

        @SerializedName("read_at")
        public String readAt = "";

        @SerializedName("created_at")
        public String createdAt = "";

        @SerializedName("updated_at")
        public String updatedAt = "";


        public Sender getSender() {
            return sender;
        }

        public void setSender(Sender sender) {
            this.sender = sender;
        }

        @SerializedName("sender")
        public Sender sender;

        public class Sender {

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getMobile_number() {
                return mobile_number;
            }

            public void setMobile_number(String mobile_number) {
                this.mobile_number = mobile_number;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            @SerializedName("id")
            public int id = 0;

            @SerializedName("first_name")
            public String first_name ="";
            @SerializedName("last_name")
            public String last_name ="";

            @SerializedName("mobile_number")
            public String mobile_number= "";

            @SerializedName("email")
            public String email= "";


        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSenderId() {
            return senderId;
        }

        public void setSenderId(int senderId) {
            this.senderId = senderId;
        }

        public int getRecieverId() {
            return recieverId;
        }

        public void setRecieverId(int recieverId) {
            this.recieverId = recieverId;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getReadAt() {
            return readAt;
        }

        public void setReadAt(String readAt) {
            this.readAt = readAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
/*
        public Sender getSender() {
            return sender;
        }

        public void setSender(Sender sender) {
            this.sender = sender;
        }*/

    //}

}
