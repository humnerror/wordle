package com.mvc.wordle.controller;

import com.mvc.wordle.model.Guess;
import com.mvc.wordle.service.UIService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class wordleController {

    private final UIService uiService;

    @Autowired
    public wordleController(UIService uiService) {
        this.uiService = uiService;
    }

    @GetMapping
    public String mainPage(){
        return "homepage";
    }

    @GetMapping("/game")
    public String playGame(Model model){
        Guess open = uiService.pageOpen();
        model.addAttribute("guess",open);
        model.addAttribute("meanings",uiService.getListOfMeanings());
        return "playGame";
    }

    @PostMapping("/gameON")
    public String GameOn(@Valid @ModelAttribute Guess guess, BindingResult result, Model model){
        model.addAttribute("meanings",uiService.getListOfMeanings());
        if(result.hasFieldErrors()) return "playGame";
        uiService.ValidateGuess(guess);
        model.addAttribute("guess",guess);
        model.addAttribute("win", uiService.checkAns(guess.getDash()));
        return "playGame";
    }

    @GetMapping("/playAgain")
    public String playAgain(){
        return "redirect:/game";
    }
    @GetMapping("/back")
    public String redirection(){
        return "homepage";
    }



}
