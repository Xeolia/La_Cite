package com.la_cite.surfrider.service;

import com.la_cite.surfrider.Products;
import com.la_cite.surfrider.repository.*;
import com.la_cite.surfrider.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    private JwtUtil tokenUtil;

    public boolean enregistrer(Products products){
        if(productsRepository.save(products)!=null)
        {
            return true;
        }
        return false;
    }

    public String getUsernameFromToken(String token){
        token = token.substring(7);
        return tokenUtil.extractUsername(token);
    }

    public List<Products> getProductsByUsername(String token){
        return productsRepository.findAllByCreatorEquals(token);
    }
}