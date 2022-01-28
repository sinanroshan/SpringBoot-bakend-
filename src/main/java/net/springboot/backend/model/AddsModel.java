package net.springboot.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addandoffers")
public class AddsModel {
    @Id
    private String add1;
    private String add2;
    private String add3;
    private String add4;
    private String add5;
    
    public AddsModel(String add1, String add2, String add3, String add4, String add5) {
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.add4 = add4;
        this.add5 = add5;
    }

    public AddsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getAdd4() {
        return add4;
    }

    public void setAdd4(String add4) {
        this.add4 = add4;
    }

    public String getAdd5() {
        return add5;
    }

    public void setAdd5(String add5) {
        this.add5 = add5;
    }
    
}
