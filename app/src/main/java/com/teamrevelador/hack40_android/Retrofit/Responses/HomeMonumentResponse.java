package com.teamrevelador.hack40_android.Retrofit.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 20/03/18.
 */

public class HomeMonumentResponse implements Serializable{


        @SerializedName("name")
        private String name;
        @SerializedName("latitude")
        private String latitude;
        @SerializedName("longitude")
        private String longitude;
        @SerializedName("description")
        private String description;
        @SerializedName("photo")
        private String photo;
        @SerializedName("rating")
        private String rating;
        @SerializedName("visits")
        private String visits;
        @SerializedName("fact1")
        private String fact1;
        @SerializedName("fact2")
        private String fact2;
        @SerializedName("fact3")
        private String fact3;
        @SerializedName("fact4")
        private String fact4;
        @SerializedName("fact5")
        private String fact5;
        @SerializedName("fact6")
        private String fact6;
        @SerializedName("fact7")
        private String fact7;
        @SerializedName("fact8")
        private String fact8;
        @SerializedName("fact9")
        private String fact9;
        @SerializedName("fact10")
        private String fact10;

    public HomeMonumentResponse() {
    }

    public HomeMonumentResponse(String name, String latitude, String longitude, String description, String photo, String rating, String visits, String fact1, String fact2, String fact3, String fact4, String fact5, String fact6, String fact7, String fact8, String fact9, String fact10) {

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.photo = photo;
        this.rating = rating;
        this.visits = visits;
        this.fact1 = fact1;
        this.fact2 = fact2;
        this.fact3 = fact3;
        this.fact4 = fact4;
        this.fact5 = fact5;
        this.fact6 = fact6;
        this.fact7 = fact7;
        this.fact8 = fact8;
        this.fact9 = fact9;
        this.fact10 = fact10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getFact1() {
        return fact1;
    }

    public void setFact1(String fact1) {
        this.fact1 = fact1;
    }

    public String getFact2() {
        return fact2;
    }

    public void setFact2(String fact2) {
        this.fact2 = fact2;
    }

    public String getFact3() {
        return fact3;
    }

    public void setFact3(String fact3) {
        this.fact3 = fact3;
    }

    public String getFact4() {
        return fact4;
    }

    public void setFact4(String fact4) {
        this.fact4 = fact4;
    }

    public String getFact5() {
        return fact5;
    }

    public void setFact5(String fact5) {
        this.fact5 = fact5;
    }

    public String getFact6() {
        return fact6;
    }

    public void setFact6(String fact6) {
        this.fact6 = fact6;
    }

    public String getFact7() {
        return fact7;
    }

    public void setFact7(String fact7) {
        this.fact7 = fact7;
    }

    public String getFact8() {
        return fact8;
    }

    public void setFact8(String fact8) {
        this.fact8 = fact8;
    }

    public String getFact9() {
        return fact9;
    }

    public void setFact9(String fact9) {
        this.fact9 = fact9;
    }

    public String getFact10() {
        return fact10;
    }

    public void setFact10(String fact10) {
        this.fact10 = fact10;
    }
}
