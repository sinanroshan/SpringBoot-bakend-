package net.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.model.InvoiceData;
import net.springboot.backend.repository.InvoiceDataRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class InvoceDataController {
    
    @Autowired
	private InvoiceDataRepository invoiceDataRepository;

        @RequestMapping(path="/getinvoice/{invNo}",method = RequestMethod.GET)
			public List<InvoiceData>
			getInvoice(@PathVariable String invNo){
		return invoiceDataRepository.findByinv(invNo);	
	}
}
