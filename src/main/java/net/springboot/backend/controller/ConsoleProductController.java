package net.springboot.backend.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.springboot.backend.model.ConsoleProduct;
import net.springboot.backend.repository.ConsoleRepository;

@CrossOrigin
@RestController
@RequestMapping("/console")
public class ConsoleProductController {
    @Autowired
    private ConsoleRepository consoleRepository;

    @GetMapping("/Allproducts")
	// get all Products
			public List<String[]>
			getAllProducts(){
		    return consoleRepository.ShowAll();
            }
    @PostMapping("/AddProduct")
	//method = RequestMethod.POST, consumes = "application/json"
	public ConsoleProduct Addproduct(@RequestBody ConsoleProduct product) {
		System.out.println(product.getCess());
			return product;
			}

	@GetMapping(value="/pid")
	public String pid() {
		System.out.println(consoleRepository.getPid());
		return consoleRepository.getPid();
	}
	@RequestMapping(path = "keyword/{key}",method = RequestMethod.GET)
	public List<String> serachKey(@PathVariable String key){
		return consoleRepository.getPnames(key);
	}
			
}
