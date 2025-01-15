package com.mvc.wordle.service;

import com.mvc.wordle.feign.WordClient;
import com.mvc.wordle.model.Definitions;
import com.mvc.wordle.model.Meanings;
import com.mvc.wordle.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeaningService {

    private final WordClient feign;

    @Autowired
    public MeaningService(WordClient feign) {
        this.feign = feign;
    }

    public List<String> getListOfMeanings(String word){
        List<Word> wordAndMeanings = feign.getWordAndMeanings(word);
        return extractNounFromList(wordAndMeanings);
    }

    private List<String> extractNounFromList(List<Word> wordAndMeanings) {
        return wordAndMeanings.stream()
                .map(Word::getMeanings)
                .flatMap(List::stream)
                .filter(meanings -> meanings.getPartOfSpeech().equalsIgnoreCase("noun"))
                .map(Meanings::getDefinitions)
                .flatMap(List::stream)
                .map(Definitions::getDefinition)
                .limit(3)
                .toList();
    }
}
