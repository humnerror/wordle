package com.mvc.wordle.model;

import java.util.List;


public class Definitions {
    private String definition;
    private List<String> synonyms;
    private List<String> antonyms;

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Definitions{" +
                "definition='" + definition + '\'' +
                ", synonyms=" + synonyms +
                ", antonyms=" + antonyms +
                '}';
    }
}
