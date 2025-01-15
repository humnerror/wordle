package com.mvc.wordle.service;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class RandomService {

    private final List<String> fullWordList;

    public RandomService() {
        try {
            fullWordList = new FileService().readFileLinesToArray();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String getRandomWord(){
        return fullWordList.get(new Random().nextInt(fullWordList.size()));
    }

}
