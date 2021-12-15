package net.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.model.Godown;
import net.springboot.backend.repository.SuperCategoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GodownController {

	
	@Autowired
	private SuperCategoryRepository superCategoryRepository;
	
	@GetMapping("/super_category")
	public List<Godown>
			getallSuperCategories(){
		return superCategoryRepository.findAll();
	}
}
