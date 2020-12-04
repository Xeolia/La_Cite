package com.la_cite.surfrider.service;

import com.la_cite.surfrider.Feedback;
import com.la_cite.surfrider.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public boolean enregistrer(Feedback feedback){
        if(feedbackRepository.save(feedback)!=null)
        {
            return true;
        }
        return false;
    }

}
