package com.sp.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.sp.order_service.dao.OrderRepository;
import com.sp.order_service.dto.ProductDto;


@Service
public class OrderService {
	
//	@Autowired
//	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<ProductDto> getProducts()
	{
		List<ProductDto> products=restTemplate.getForObject("http://localhost:8080/api1/products", List.class);
		//ProductList productList=restTemplate.getForObject("http://localhost:8080/api1/products", ProductList.class);
		//List<ProductDto> productDto=productList.getProducts();
		return products;
	}

	public ProductDto getProductById(Long id)
	{
		ProductDto product=restTemplate.getForObject("http://localhost:8080/api1/products/"+id, ProductDto.class);
		return product;
	}

}
