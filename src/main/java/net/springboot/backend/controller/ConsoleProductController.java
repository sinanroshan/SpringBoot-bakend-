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
			public List<ConsoleProduct>
			getAllProducts(){
		    return consoleRepository.ShowAll();
            }
	
	//@PostMapping("/SaveImage")
	@RequestMapping(path = "SaveImage/",method = RequestMethod.POST)
	public String SaveImage(@RequestParam("name") String filename,@RequestParam("type") String type,@RequestBody MultipartFile image){
	//public String SaveImage(@RequestBody Image image){
		System.out.println(filename);
		System.out.println(type);
		System.out.println(image.getSize());
		return "done";
	}

    @PostMapping(value =  "/AddProduct")
	public String Addproduct(@RequestBody ConsoleProduct product){
			consoleRepository.saveProduct(product.getName(), product.getProductID(),product.getBarcode(),product.getCategory(),product.getSub_Category(),
				product.getUnit(),product.getHsn_Code(),product.getGst(),product.getCess(),product.getCurrent_Stock(),product.getOpening_Stock(),
				product.getPurchase_Rate(),product.getRetail_Rate(),product.getMrp(),product.getCost(),product.getWhole_Rate(),product.getKayImage().toString(),
				"PDT"+product.getBarcode());
			return "sved";
			}
	
	@RequestMapping(path = "EditProduct/{key}/",method = RequestMethod.POST)
	public String EditProduct(@PathVariable String key,@RequestBody ConsoleProduct product) {
			consoleRepository.UpdateProduct(key,product.getName(), product.getProductID(),product.getBarcode(),product.getCategory(),product.getSub_Category(),
			product.getUnit(),product.getHsn_Code(),product.getGst(),product.getCess(),product.getCurrent_Stock(),product.getOpening_Stock(),
			product.getPurchase_Rate(),product.getRetail_Rate(),product.getMrp(),product.getCost(),product.getWhole_Rate());
			return "Updated";
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
