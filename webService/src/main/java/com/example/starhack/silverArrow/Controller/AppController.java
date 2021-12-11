package com.example.starhack.silverArrow.Controller;

import com.example.starhack.silverArrow.Service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/AppService/v1")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/signup")
    public void SignUp(@RequestParam String username, @RequestParam String password) {
        //Sign Up
    }

    @PostMapping()
    public void profileUpdate(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
                              @RequestParam String phone, @RequestParam String birthday) {
        //Update Profile
    }

    @GetMapping("/getMatchs/{id}")
    public void GetMatchById(@PathVariable String id) {
        //Get Matchs
    }
}
