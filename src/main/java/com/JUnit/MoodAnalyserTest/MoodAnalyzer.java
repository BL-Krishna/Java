package com.JUnit.MoodAnalyserTest;

public class MoodAnalyzer {

    public String moodAnalyzer(String message){
        if (message==null || message.isEmpty()){
            return "NEUTRAL";
        }
        if (message.toLowerCase().contains("sad")){
            return "SAD";
        }else {
            return "HAPPY";
        }

    }
}
