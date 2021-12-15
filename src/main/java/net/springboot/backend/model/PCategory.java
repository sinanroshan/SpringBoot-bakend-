package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="p_category")
public class PCategory {
	@Id
	@Column(name = "name")
	private String Category;
	
	@Column(name= "godown")
	private String superCategory;

	public PCategory(String category, String superCategory) {
		super();
		Category = category;
		this.superCategory = superCategory;
	}

	public PCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(String superCategory) {
		this.superCategory = superCategory;
	}

	
}
