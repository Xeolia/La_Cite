package com.la_cite.surfrider.controller;

import com.la_cite.surfrider.Feedback;
import com.la_cite.surfrider.User;
import com.la_cite.surfrider.service.FeedbackService;
import com.la_cite.surfrider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin(origins = "*")
public class FeedBackController {
    @Autowired
    FeedbackService feedbackService;


    @PostMapping("feedback/create")
    @ResponseBody
    public boolean createFeedBack(@RequestBody Feedback feedback, @RequestHeader("Authorization")Map<String, String> headers )
    {
        String token = feedbackService.getUsernameFromToken(headers.get("authorization"));
        feedback.setCreator(token);
        return feedbackService.enregistrer(feedback);
    }
    @GetMapping("feedback/get")
    @ResponseBody
    public List<Feedback> getFeedBack(@RequestHeader("Authorization")Map<String, String> headers )
    {
        String token = feedbackService.getUsernameFromToken(headers.get("authorization"));
        return feedbackService.getFeedbackRepository(token);
    }

}
