package com.la_cite.surfrider.service;

import com.la_cite.surfrider.Frequentation;
import com.la_cite.surfrider.repository.*;
import com.la_cite.surfrider.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrequentationService {

    @Autowired
    FrequentationRepository frequentationRepository;
    @Autowired
    private JwtUtil tokenUtil;

    public boolean enregistrer(Frequentation frequentation){
        if(frequentationRepository.save(frequentation)!=null)
        {
            return true;
        }
        return false;
    }

    public String getUsernameFromToken(String token){
        token = token.substring(7);
        return tokenUtil.extractUsername(token);
    }
}
