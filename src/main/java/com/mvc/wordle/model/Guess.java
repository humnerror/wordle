package com.mvc.wordle.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class Guess {

    private String dash;

    @NotBlank(message = "Enter any single character")
    @Pattern(regexp = "[a-zA-Z]", message = "Enter one character")
    private String ans;
    private Integer remainingTry;
    private String random;


    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Integer getRemainingTry() {
        return remainingTry;
    }

    public void setRemainingTry(Integer remainingTry) {
        this.remainingTry = remainingTry;
    }

    @Override
    public String toString() {
        return "Guess{" +
                "dash='" + dash + '\'' +
                ", ans='" + ans + '\'' +
                ", remainingTry=" + remainingTry +
                ", random='" + random + '\'' +
                '}';
    }
}
