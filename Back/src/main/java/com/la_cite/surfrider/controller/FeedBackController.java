package com.la_cite.surfrider.controller;

import com.la_cite.surfrider.Feedback;
import com.la_cite.surfrider.User;
import com.la_cite.surfrider.service.FeedbackService;
import com.la_cite.surfrider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@CrossOrigin(origins = "*")
public class FeedBackController {
    @Autowired
    FeedbackService feedbackService;


    @PostMapping("feedback/create")
    @ResponseBody
    public boolean createFeedBack(@RequestBody Feedback feedback)
    {
        return feedbackService.enregistrer(feedback);
    }

}
