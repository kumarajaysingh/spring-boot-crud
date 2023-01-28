package com.skillsoft.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.skillsoft.springboot.model.Product;
import com.skillsoft.springboot.repository.ProductRepository;

@SpringBootApplication
@EnableCaching
public class SpringbootApplication  implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product("Television", "Electronics"));
		productRepository.save(new Product("AC", "Electronics"));
		productRepository.save(new Product("Sofa", "Furniture"));
		productRepository.save(new Product("Ball", "Sports"));
		productRepository.save(new Product("Bed", "Furniture"));
	}

}
