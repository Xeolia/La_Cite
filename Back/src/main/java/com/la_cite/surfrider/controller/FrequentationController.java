package com.la_cite.surfrider.controller;

import com.la_cite.surfrider.Frequentation;
import com.la_cite.surfrider.service.FrequentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.StringTokenizer;


@RestController
@CrossOrigin(origins = "*")

public class FrequentationController {
    @Autowired
    FrequentationService frequentationService;

    @PostMapping("frequentation/create")
    @ResponseBody
    public boolean createFrequentation(@RequestBody Frequentation frequentation, @RequestHeader("Authorization") Map<String, String> headers)
    {
        String token = frequentationService.getUsernameFromToken(headers.get("authorization"));
        frequentation.setCreator(token);
        return frequentationService.enregistrer(frequentation);
    }
}