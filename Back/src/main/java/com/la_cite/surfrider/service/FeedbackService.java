package com.la_cite.surfrider.service;

import com.la_cite.surfrider.Feedback;
import com.la_cite.surfrider.repository.*;
import com.la_cite.surfrider.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public boolean enregistrer(Feedback feedback){
        if(feedbackRepository.save(feedback)!=null)
        {
            return true;
        }
        return false;
    }
    public String  getUsernameFromToken(String token){
        token=token.substring(7);
        return jwtUtil.extractUsername(token);
    }

    public List<Feedback> getFeedbackRepository(String token) {
        return feedbackRepository.findAllByCreatorEquals(token);
    }
}
