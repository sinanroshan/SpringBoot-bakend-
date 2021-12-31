package net.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.model.OrderData;
import net.springboot.backend.repository.OrderRepository;

@CrossOrigin
@RestController
@RequestMapping("/console")
public class OrderDataController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
	// get all Products
			public List<OrderData>
			getAllProducts(){
		    return orderRepository.getAll();
            }
}
