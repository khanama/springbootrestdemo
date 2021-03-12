package com.PracticeAssignment.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.PracticeAssignment.rest.model.Product;
import com.PracticeAssignment.rest.model.Products;
import com.PracticeAssignment.rest.util.FixerIOClient;

@Repository
public class ProductDAO 
{
	@Autowired
	FixerIOClient fixerio ;
	
    private static Products list = new Products();
    
    static 
    {
        list.getproductsList().add(new Product(1, "product1", "some product1", 100));
        list.getproductsList().add(new Product(2, "product2", "some product2", 200));
        list.getproductsList().add(new Product(3, "product3", "some product3", 300));
        list.getproductsList().add(new Product(4, "product4", "some product4", 400));
    }
    
    public Products getAllProducts() 
    {
        return list;
    }

	public Products getAllProducts(String currency) {
		double exchangeAmt =0;
		for (Product p:list.getproductsList() ) {
			exchangeAmt = fixerio.convert(currency, Product.CURRENCY, p.getPrice());
			p.setPrice(exchangeAmt);
		}
		
		return list;
	}
    
    
}
