package net.springboot.backend.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.springboot.backend.model.ConsoleLedger;
import net.springboot.backend.model.ConsoleProduct;
import net.springboot.backend.repository.ConsoleLedgerRepo;
import net.springboot.backend.repository.ConsoleRepository;

@CrossOrigin
@RestController
@RequestMapping("/console")
public class ConsoleProductController {
    @Autowired
    private ConsoleRepository consoleRepository;
	@Autowired
	private ConsoleLedgerRepo LedgerRepo;

    @GetMapping("/Allproducts")
	// get all Products
			public List<ConsoleProduct>
			getAllProducts(){
		    return consoleRepository.ShowAll();
            }
	
	//@PostMapping("/SaveImage")
	@RequestMapping(value = "SaveImage/",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String SaveImage(@RequestPart("name") String filename,@RequestPart("type") String type,@RequestPart("imageFile") MultipartFile image){
		try {
		File path = new File("E:\\TEST\\angular\\Ecomerce-Console\\src\\assets\\images\\products\\" + filename+""+type+".jpg");
		File path1 = new File("E:\\TEST\\angular\\eComerce\\src\\assets\\images\\products\\" + filename+""+type+".jpg");
		path.createNewFile();
		path1.createNewFile();
		FileOutputStream output = new FileOutputStream(path);
		FileOutputStream output1 = new FileOutputStream(path1);
		output.write(image.getBytes());
		output.close();
		output1.write(image.getBytes());
		output1.close();
		return "../assets/images/products/"+ filename+""+type+".jpg";
	} catch (Exception e) {
		return "Errorr";
	}
	}
	

    @PostMapping(value =  "/AddProduct")
	public String Addproduct(@RequestBody ConsoleProduct product){
		Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String date=(formatter.format(calendar.getTime()));
				
			consoleRepository.saveProduct(product.getName(), product.getProductID(),product.getBarcode(),product.getCategory(),product.getSub_Category(),
				product.getUnit(),product.getHsn_Code(),product.getGst(),product.getCess(),product.getCurrent_Stock(),product.getOpening_Stock(),
				product.getPurchase_Rate(),product.getRetail_Rate(),product.getMrp(),product.getCost(),product.getWhole_Rate(),product.getKeyImage(),
				product.getImage1(),product.getImage2(),product.getImage3(),product.getImage4(),"PDT"+product.getBarcode(),date,product.getDiscription());
			return "sved";
			}
	
	@RequestMapping(path = "EditProduct/{key}/",method = RequestMethod.POST)
	public String EditProduct(@PathVariable String key,@RequestBody ConsoleProduct product) {
			consoleRepository.UpdateProduct(key,product.getName(), product.getProductID(),product.getBarcode(),product.getCategory(),product.getSub_Category(),
			product.getUnit(),product.getHsn_Code(),product.getGst(),product.getCess(),product.getCurrent_Stock(),product.getOpening_Stock(),
			product.getPurchase_Rate(),product.getRetail_Rate(),product.getMrp(),product.getCost(),product.getWhole_Rate(),product.getKeyImage(),
			product.getImage1(),product.getImage2(),product.getImage3(),product.getImage4(),product.getDiscription() );
			return "Updated";
			}	
	//

	@GetMapping(value="/pid")
	public String pid() {
		return consoleRepository.getPid();
	}
	@RequestMapping(path = "keyword/{key}",method = RequestMethod.GET)
	public List<String> serachKey(@PathVariable String key){
		return consoleRepository.getPnames(key);
	}
	@RequestMapping(path = "Ledger/{pname}",method = RequestMethod.GET)
	public List<ConsoleLedger> getLedger(@PathVariable String pname){
		String[] inv = consoleRepository.getprodInv(pname);
		LedgerRepo.resetTempTable();
		int qty=inv.length;
		for(int i=0; i<qty;i++){
			String[][] Temp= consoleRepository.getOrderData(inv[i],pname);
			LedgerRepo.setTable(Temp[0][2],Temp[0][3],Temp[0][4],Temp[0][5],Temp[0][6],Temp[0][7]);
		}
		return LedgerRepo.getLedger();
	}
			
}
