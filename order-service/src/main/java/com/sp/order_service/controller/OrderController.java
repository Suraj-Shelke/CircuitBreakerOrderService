package com.sp.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.order_service.dto.ProductDto;
import com.sp.order_service.model.Order;
import com.sp.order_service.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/api2/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/products")
	public List<ProductDto> getProducts()
	{
		return orderService.getProducts();
	}
	
	@CircuitBreaker(name = "ProductService", fallbackMethod = "fallbackGetProductById")
	@GetMapping(value = "/products/{id}")
	public ProductDto getProductById(@PathVariable Long id)
	{
		return orderService.getProductById(id);
	}
	
	public ProductDto fallbackGetProductById(Long id, Throwable throwable)
	{
		return new ProductDto(id,"Fallback Product",20);
	}

}
