package com.la_cite.surfrider.controller;

import com.la_cite.surfrider.Products;
import com.la_cite.surfrider.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


@RestController
@CrossOrigin(origins = "*")

public class ProductsController {
    @Autowired
    ProductsService productsService;

    @PostMapping("products/create")
    @ResponseBody
    public boolean createProducts(@RequestBody Products products, @RequestHeader("Authorization") Map<String, String> headers)
    {
        String token = productsService.getUsernameFromToken(headers.get("authorization"));
        products.setCreator(token);
        return productsService.enregistrer(products);
    }

    @GetMapping("products/get")
    public List<Products> getProducts(@RequestHeader("Authorization") Map<String, String> headers)
    {
        String token = productsService.getUsernameFromToken(headers.get("authorization"));
        return productsService.getProductsByUsername(token);
    }
}
