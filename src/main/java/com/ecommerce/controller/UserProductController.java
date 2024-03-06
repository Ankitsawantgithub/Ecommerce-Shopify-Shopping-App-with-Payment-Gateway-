package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductException;
import com.ecommerce.service.ProductService;
import com.ecommerce.user.domain.ProductSubCategory;

@RestController
@RequestMapping("/api")
public class UserProductController {
	
	@Autowired
	private ProductService productService;
	
    /**
     * It fetch  data  from  database and  give  list of  this  following  parameters
     * @param category
     * @param color
     * @param size
     * @param minPrice
     * @param maxPrice
     * @param minDiscount
     * @param sort
     * @param stock
     * @param pageNumber
     * @param pageSize
     * @return
     */
	
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getAllProduct(@RequestParam String category,
			@RequestParam List<String>color,@RequestParam List<String> size,@RequestParam Integer minPrice,
			@RequestParam Integer maxPrice, @RequestParam Integer minDiscount, @RequestParam String sort, 
			@RequestParam String stock, @RequestParam Integer pageNumber,@RequestParam Integer pageSize){

		
		Page<Product> res= productService.getAllProduct(category, color, size, minPrice, maxPrice, minDiscount, sort,stock,pageNumber,pageSize);
		
		System.out.println("complete products");
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
		
	}
	

	
	/**
	 * Get Products  by  id
	 * @param productId
	 * @return
	 * @throws ProductException
	 */
	
	@GetMapping("/products/id/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable Long productId) throws ProductException{
		
		Product product=productService.findProductById(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}

	/**
	 * This Api searches the product
	 * @param q
	 * @return
	 */
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam String q){
		
		List<Product> products=productService.searchProduct(q);
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
}
