package com.mvc.wordle.model;

import java.util.List;


public class Word {
    private String word;
    private List<Meanings> meanings;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", meanings=" + meanings +
                '}';
    }
}
