package com.la_cite.surfrider.controller;

import com.la_cite.surfrider.Feedback;
import com.la_cite.surfrider.User;
import com.la_cite.surfrider.service.FeedbackService;
import com.la_cite.surfrider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

public class FeedBackController {
    @Autowired
    FeedbackService feedbackService;
    //● Ville
    //● Spot
    //● Nom du Waterman
    //● Date
    //● Heure début baignade
    //● Heure fin baignade
    //● Durée de baignade
    //(hh:mm)

    @PostMapping("/user/feedback")
    @ResponseBody
    public boolean createFeedBack(@RequestBody Feedback feedback)
    {
        return feedbackService.enregistrer(feedback);
    }

}
