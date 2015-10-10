/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grounded.business;

import java.io.Serializable;

/**
 *
 * @author Primary
 */
public class Settings implements Serializable{
    
    private String appType; //can be minecraft, scratch, browser only
    //private String restrictedRange;    //can be graveyard, early, brunch, lunch, afternoon, evening, night
    private String customMessage; //can be mull, restricted, bedtime, warning
    // time ranges
    private String graveyard;
    private String early;
    private String brunch;
    private String lunch;
    private String afternoon;
    private String evening;
    private String night;         
    
    // no args constructor sets all values to "no"
    public Settings(){
        appType = "";
        customMessage = "";
        graveyard = "";
        early = "";
        brunch = "";
        lunch = "";
        afternoon = "";
        evening = "";
        night = "";
    }
    
    /**
     * @return the customMessage
     */
    public String getCustomMessage() {
        
        if (customMessage == null){
            customMessage = "none";
        } else if (customMessage.equals("restricted")) {
            customMessage = "Access restricted.";
        } else if (customMessage.equals("bedtime")){
            customMessage = "Go to bed!";
        } else { // (customMessage == "warning"
            customMessage = "This attempt has been logged. After 3 attempts you will be grounded!";
        } 
        return customMessage;
    }

    /**
     * @param customMessage the customMessage to set
     */
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;

    }

    /**
     * @return the appType
     */
    public String getAppType() {
        return appType;
    }

    /**
     * @param appType the appType to set
     */
    public void setAppType(String appType) {
        this.appType = appType;
    }

    /**
     * @return the graveyard
     */
    public String getGraveyard() {
        
        return graveyard;
    }

    /**
     * @param graveyard the graveyard to set
     */
    public void setGraveyard(String graveyard) {
        this.graveyard = graveyard;
    }

    /**
     * @return the early
     */
    public String getEarly() {
        return early;
    }

    /**
     * @param early the early to set
     */
    public void setEarly(String early) {
        this.early = early;
    }

    /**
     * @return the brunch
     */
    public String getBrunch() {
        return brunch;
    }

    /**
     * @param brunch the brunch to set
     */
    public void setBrunch(String brunch) {
        this.brunch = brunch;
    }

    /**
     * @return the lunch
     */
    public String getLunch() {
        return lunch;
    }

    /**
     * @param lunch the lunch to set
     */
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    /**
     * @return the afternoon
     */
    public String getAfternoon() {
        return afternoon;
    }

    /**
     * @param afternoon the afternoon to set
     */
    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * @return the evening
     */
    public String getEvening() {
        return evening;
    }

    /**
     * @param evening the evening to set
     */
    public void setEvening(String evening) {
        this.evening = evening;
    }

    /**
     * @return the night
     */
    public String getNight() {
        return night;
    }

    /**
     * @param night the night to set
     */
    public void setNight(String night) {
        this.night = night;
    }

}
