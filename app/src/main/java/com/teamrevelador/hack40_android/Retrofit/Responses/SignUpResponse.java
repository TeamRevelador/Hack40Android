package com.teamrevelador.hack40_android.Retrofit.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 20/03/18.
 */

public class SignUpResponse implements Serializable {

    @SerializedName("msg")
    private String message;

    public SignUpResponse() {
    }

    public SignUpResponse(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
