package com.teamrevelador.hack40_android;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class HomeMonumentModel implements Serializable{

    private String monumentName;
    private String monumentVisits;
    private String monumentDistance;
    private String monumentRatingText;
    private String monumentDescription;
    private String monumentImageUrl;

    public HomeMonumentModel() {
    }

    public HomeMonumentModel(String monumentName, String monumentVisits, String monumentDistance, String monumentRatingText, String monumentDescription, String monumentImageUrl) {

        this.monumentName = monumentName;
        this.monumentVisits = monumentVisits;
        this.monumentDistance = monumentDistance;
        this.monumentRatingText = monumentRatingText;
        this.monumentDescription = monumentDescription;
        this.monumentImageUrl = monumentImageUrl;
    }

    public String getMonumentName() {
        return monumentName;
    }

    public void setMonumentName(String monumentName) {
        this.monumentName = monumentName;
    }

    public String getMonumentVisits() {
        return monumentVisits;
    }

    public void setMonumentVisits(String monumentVisits) {
        this.monumentVisits = monumentVisits;
    }

    public String getMonumentDistance() {
        return monumentDistance;
    }

    public void setMonumentDistance(String monumentDistance) {
        this.monumentDistance = monumentDistance;
    }

    public String getMonumentRatingText() {
        return monumentRatingText;
    }

    public void setMonumentRatingText(String monumentRatingText) {
        this.monumentRatingText = monumentRatingText;
    }

    public String getMonumentDescription() {
        return monumentDescription;
    }

    public void setMonumentDescription(String monumentDescription) {
        this.monumentDescription = monumentDescription;
    }

    public String getMonumentImageUrl() {
        return monumentImageUrl;
    }

    public void setMonumentImageUrl(String monumentImageUrl) {
        this.monumentImageUrl = monumentImageUrl;
    }
}
