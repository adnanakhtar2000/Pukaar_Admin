package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Sessions_LogResponse {


    @SerializedName("data")
    public ArrayList<FirstDatum> Fdata = null;

    public class FirstDatum {
        @SerializedName("id")
        public int id = 0;

        @SerializedName("client_id")
        public int client_id = 0;


        @SerializedName("therapist_id")
        public int therapist_id = 0;

        @SerializedName("session_taken")
        public String session_taken = "";
        @SerializedName("session_taken_time")
        public String session_taken_time = "";

        @SerializedName("therapist")
        public Therapist therapist;

        public class Therapist {
            @SerializedName("id")
            public int id = 0;

            @SerializedName("first_name")
            public String first_name = "";
            @SerializedName("last_name")
            public String last_name = "";
            @SerializedName("mobile_number")
            public String mobile_number = "";
            @SerializedName("email")
            public String email = "";
            @SerializedName("created_at")
            public String created_at = "";
            @SerializedName("updated_at")
            public String updated_at = "";

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

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public int getTherapist_id() {
            return therapist_id;
        }

        public void setTherapist_id(int therapist_id) {
            this.therapist_id = therapist_id;
        }

        public String getSession_taken() {
            return session_taken;
        }

        public void setSession_taken(String session_taken) {
            this.session_taken = session_taken;
        }

        public String getSession_taken_time() {
            return session_taken_time;
        }

        public void setSession_taken_time(String session_taken_time) {
            this.session_taken_time = session_taken_time;
        }

        public Therapist getTherapist() {
            return therapist;
        }

        public void setTherapist(Therapist therapist) {
            this.therapist = therapist;
        }

    }
}