package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_godown")
public class Godown {

	@Id
	@Column(name = "g_name")
	private String godown_name;

	public Godown(String godown_name) {
		super();
		this.godown_name = godown_name;
	}

	public Godown() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGodown_name() {
		return godown_name;
	}

	public void setGodown_name(String godown_name) {
		this.godown_name = godown_name;
	}

	
}
