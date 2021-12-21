package net.springboot.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
			public List<ConsoleProduct>
			getAllProducts(){
		    return consoleRepository.ShowAll();
            }
    @PostMapping("/AddProduct")
	//method = RequestMethod.POST, consumes = "application/json"
	public String Addproduct(@RequestBody ConsoleProduct product) {
		System.out.println(product.getProductID());
			consoleRepository.saveProduct(product.getName(), product.getProductID(),product.getBarcode(),product.getCategory(),product.getSub_Category(),
					product.getUnit(),product.getHsn_Code(),product.getGst(),product.getCess(),product.getCurrent_Stock(),product.getOpening_Stock(),
					product.getPurchase_Rate(),product.getRetail_Rate(),product.getMrp(),product.getCost(),product.getWhole_Rate());
			return "sved";
			}

	@GetMapping(value="/pid")
	public String pid() {
		return consoleRepository.getPid();
	}
	@RequestMapping(path = "keyword/{key}",method = RequestMethod.GET)
	public List<String> serachKey(@PathVariable String key){
		return consoleRepository.getPnames(key);
	}
			
}
