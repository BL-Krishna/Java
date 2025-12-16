package com.JunitTest.moodAnalyzer;
import org.junit.jupiter.api.Test;

import com.JUnit.MoodAnalyserTest.MoodAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodAnalyzerTest {
    @Test
    void givensadmessage_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood=moodAnalyzer.moodAnalyzer("I am Feeling Sad");
        assertEquals("SAD",mood);
    }
    @Test
    void givenhappymessage_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood=moodAnalyzer.moodAnalyzer("I am Feeling Happy");
        assertEquals("HAPPY",mood);
    }
    @Test
    void givenneutralymessage_ShouldReturnNeutral(){
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood=moodAnalyzer.moodAnalyzer("");
        assertEquals("NEUTRAL",mood);
    }

}
