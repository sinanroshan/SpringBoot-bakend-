package net.springboot.backend.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(path="/AddProduct/{data}",method = RequestMethod.GET)
	public HttpStatus getCategory(@PathVariable Any data) {
        //System.out.println( data.toString("name"));
			return null;

			}
}
