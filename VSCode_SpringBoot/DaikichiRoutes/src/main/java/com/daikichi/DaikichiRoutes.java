package com.daikichi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiRoutes {
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
    
    @RequestMapping("/tomorrow")
    // 3. Method that maps to the request route above
    public String tomorrow() { // 3
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
    
}
