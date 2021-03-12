package com.PracticeAssignment.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Products 
{
    private List<Product> productsList;
    
    public List<Product> getproductsList() {
        if(productsList == null) {
        	productsList = new ArrayList<>();
        }
        return productsList;
    }
 
    public void setproductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
