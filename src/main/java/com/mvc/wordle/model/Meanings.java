package com.mvc.wordle.model;

import java.util.List;


public class Meanings {
    private String partOfSpeech;
    private List<Definitions> definitions;
    private List<String> synonyms;
    private List<String> antonyms;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    @Override
    public String toString() {
        return "Meanings{" +
                "partOfSpeech='" + partOfSpeech + '\'' +
                ", definitions=" + definitions +
                ", synonyms=" + synonyms +
                ", antonyms=" + antonyms +
                '}';
    }
}
