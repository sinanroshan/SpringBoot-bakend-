package net.springboot.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import net.springboot.backend.model.Product;
import net.springboot.backend.repository.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class productController {

	@Autowired
	private ProductRepository productRepository;
	

	//toget randome Products
	@GetMapping("/products")
			public List<Product>
			getrandmProducts(){
		return productRepository.rnandom();	
	}
	
	@RequestMapping(path="/products/{Category}",method = RequestMethod.GET)
	public List<Product> getProducts(@PathVariable String Category) {
			return productRepository.findByPcategory(Category);
	}
	
	@RequestMapping(path = "search/{key}",method = RequestMethod.GET)
	public List<Product> serachProducts(@PathVariable String key){
		return productRepository.findByPnameContainingOrPcategoryContaining(key, key);
	}
	//serch keyword
	@RequestMapping(path = "keyword/{key}",method = RequestMethod.GET)
	public List<Product> serachKey(@PathVariable String key){
		return productRepository.findByPnameContaining(key);
	}
	@RequestMapping(path="/product/{name}",method = RequestMethod.GET)
	public List<Product> getProduct(@PathVariable String name) {
			return productRepository.findByProductId(name);
	}
	@RequestMapping(path = "suggesion/{key}",method = RequestMethod.GET)
	public List<Product> suggList(@PathVariable String key){
		String category= productRepository.getPcategory(key);
		return productRepository.getSuggesionList(category);
	}

	
	//@PostMapping("/save/product")
	//public void createProduct( @RequestParam ("product") String product) throws IOException, JsonMappingException, JsonProcessingException {
	//	Product prod = new ObjectMapper().readValue(product, Product.class);
		//prod.setImage1(image1.getBytes());
		//return productRepository.save(prod);
	//	System.out.println("prod");
	//}
	
	
}	
