package com.ecommerce.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.Review;
import com.ecommerce.entity.User;
import com.ecommerce.exception.ProductException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.ReviewRepository;
import com.ecommerce.request.ReviewRequest;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.ReviewService;

@Service
public class ReviewServiceImplementation implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product = productService.findProductById(req.getProductId());
		Review review = new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());

//		product.getReviews().add(review);
		productRepository.save(product);
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {

		return reviewRepository.getAllProductsReview(productId);
	}

}
