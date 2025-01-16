package com.mvc.wordle.service;

import com.mvc.wordle.Utils.GameUtils;
import com.mvc.wordle.model.Guess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UIService {

    private final RandomService randomService;

    private final MeaningService meaningService;

    private final GameUtils utils;

    @Autowired
    public UIService(RandomService randomService, GameUtils utils, MeaningService meaningService) {
        this.randomService = randomService;
        this.utils = utils;
        this.meaningService = meaningService;
    }

    private String randomWord;

    private char[] dashes;

    private List<String> meaningList;

    public void setRandomWord(){
        randomWord= randomService.getRandomWord();
        dashes = new char[randomWord.length()];
        meaningList = meaningService.getListOfMeanings(randomWord);
    }

    public Guess pageOpen(){
        Guess guess = new Guess();
        utils.resetTries();
        setRandomWord();
        guess.setDash(ToDash());
        guess.setRemainingTry(utils.TriesRemaining());
        guess.setRandom(randomWord);
        return guess;
    }

    public List<String> getListOfMeanings() {
        if (meaningList.isEmpty()){
            setRandomWord();
            getListOfMeanings();
        }
        return meaningList;
    }

    private String ToDash() {
        StringBuilder returnPage = new StringBuilder();
        for (Character e : dashes) {
            if (!randomWord.contains(e.toString())) {
                returnPage.append("_");
            } else {
                returnPage.append(e);
            }
            returnPage.append(" ");
        }
        return returnPage.toString();
    }

    public void ValidateGuess(Guess guess) {
        if(!randomWord.contains(guess.getAns())){
            utils.reduceTry();
            guess.setRemainingTry(utils.TriesRemaining());
            return;
        }
        guessedHow(guess.getAns());
        guess.setDash(ToDash());
        guess.setRandom(guess.getRandom());
    }

    private void guessedHow(String guess){
        for (int i=0; i<randomWord.length();i++) {
            if (guess.equalsIgnoreCase(String.valueOf(randomWord.charAt(i)))) {
                dashes[i] = guess.charAt(0);
            }
        }
    }

    public boolean checkAns(String word){
        String string = word.chars()
                .mapToObj(c -> (char) c)
                .filter(obj -> obj != ' ')
                .map(String::valueOf)
                .collect(Collectors.joining());
        return randomWord.equalsIgnoreCase(string);
    }


}
