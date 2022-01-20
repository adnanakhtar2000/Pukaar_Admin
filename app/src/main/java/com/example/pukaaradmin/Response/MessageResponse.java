package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

public class MessageResponse {

    @SerializedName("data")
    public FirstDatum  Fdata = null;


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

