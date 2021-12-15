package net.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.repository.ConsoleRepository;

@CrossOrigin
@RestController
@RequestMapping("/console")
public class ConsoleProduct {
    
    @Autowired
    private ConsoleRepository consoleRepository;

    @GetMapping("/Allproducts")
	// get all Products
			public List<String[]>
			getAllProducts(){
		    return consoleRepository.ShowAll();
            }
}
