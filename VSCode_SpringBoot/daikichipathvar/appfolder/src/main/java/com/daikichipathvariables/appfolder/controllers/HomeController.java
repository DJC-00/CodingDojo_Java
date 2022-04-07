package com.daikichipathvariables.appfolder.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String home() { // 3
            return "Welcome!";
    }
    @RequestMapping("/today")
    // 3. Method that maps to the request route above
    public String today() { // 3
            return "Today you will find luck in all your endeavors!";
    }
    @RequestMapping("/today/{inName}")
    public String todayName(@PathVariable("inName") String inName){
    	return "Today you will find luck in all your endeavors " + inName + "!";
    }
    @RequestMapping("/tomorrow")
    // 3. Method that maps to the request route above
    public String tomorrow() { // 3
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
    @RequestMapping("/tomorrow/{inName}")
    public String tomorrowName(@PathVariable("inName") String inName){
    	return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas " + inName + "!";
    }
    @RequestMapping("/travel")
    // 3. Method that maps to the request route above
    public String travel() { // 3
            return "You may soon travel to distant lands!";
    }
    @RequestMapping("/travel/{inCity}")
    public String travelCity(@PathVariable("inCity") String inCity){
    	return "Congratulations! You will soon travel to " + inCity + "!";
    }
    @RequestMapping("/lotto")
    // 3. Method that maps to the request route above
    public String lotto() { // 3
            return "Play the lotto and find your future!";
    }
    @RequestMapping("/lotto/{inNum}")
    public String lottoNumber(@PathVariable("inNum") int inNum){
        String stringEven = "You will take a grand journey in the near future, but be weary of tempting offers.";
        String stringOdd = "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        Boolean even = (inNum%2 == 0) ? true : false;
        if (even){
            return stringEven;
        }
    	return stringOdd;
    }
}


