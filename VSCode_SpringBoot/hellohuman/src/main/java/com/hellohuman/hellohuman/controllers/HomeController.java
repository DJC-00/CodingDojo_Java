package com.hellohuman.hellohuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String index(@RequestParam(value="a", defaultValue = "John") String searchQueryA , @RequestParam(value = "b", defaultValue = "Snow") String searchQueryB, @RequestParam(value = "c", defaultValue = "1") int searchQueryC) {
        String rString = "";
        for (int i=0; i < searchQueryC; i++){
            rString += searchQueryA + " " + searchQueryB + " ";
        }
        
        return rString;
    }
}