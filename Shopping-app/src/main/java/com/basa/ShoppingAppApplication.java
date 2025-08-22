package com.basa;

import com.basa.model.Customer;
import com.basa.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.basa.repo.*;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class ShoppingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingAppApplication.class, args);
	}
		@Bean
		public CommandLineRunner initData(CustomerRepository customerRepository,
				ProductRepository productRepository) {
			return args -> {
				// Sample data initialization
				Customer customer1 = new Customer("John", "Doe", "john@example.com", "123-456-7890");
				Customer customer2 = new Customer("Jane", "Smith", "jane@example.com", "098-765-4321");
				customerRepository.saveAll(List.of(customer1, customer2));

				Product product1 = new Product("Laptop", "High-performance laptop", new BigDecimal("999.99"), 10);
				Product product2 = new Product("Mouse", "Wireless mouse", new BigDecimal("29.99"), 50);
				Product product3 = new Product("Keyboard", "Mechanical keyboard", new BigDecimal("79.99"), 30);
				productRepository.saveAll(List.of(product1, product2, product3));
			};
		}
	}
