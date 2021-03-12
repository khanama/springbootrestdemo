package com.PracticeAssignment.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PracticeAssignment.rest.dao.ProductDAO;
import com.PracticeAssignment.rest.model.Products;

@RestController
@RequestMapping(path = "/ecom")
public class ProductController 
{
    @Autowired
    private ProductDAO productDao;
    
    @GetMapping(path="/products", produces = "application/json")
    public Products getProducts() 
    {
        return productDao.getAllProducts();
    }
    
    @GetMapping(path="/products/{currency}", produces = "application/json")
    public Products getProductsByCurrency(@PathVariable String currency) 
    {
        return productDao.getAllProducts(currency);
    }
    
    
}
