package net.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.model.PCategory;
import net.springboot.backend.repository.PCategoryRepository;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class PcategoryController {

	@Autowired
	private PCategoryRepository pCategoryRepository;
	
	@RequestMapping(path="/category/{SuperCategory}",method = RequestMethod.GET)
	public List<PCategory> getCategory(@PathVariable String SuperCategory) {
			return pCategoryRepository.findBySuperCategory(SuperCategory);
			}
}
