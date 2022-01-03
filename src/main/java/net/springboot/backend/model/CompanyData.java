package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyData {
    
    @Id
    @Column(name = "cmp_name")
    private String Name;
    @Column(name = "cmp_add1")
    private String Address1;
    @Column(name = "cmp_add2")
    private String Addres2;
    @Column(name = "cmp_phone")
    private String phone;
    @Column(name = "cmp_email")
    private String email;
    @Column(name = "cmp_site")
    private String website;
    @Column(name = "cmp_gstno")
    private String gstNo;
    @Column(name = "cmp_city")
    private String City;
    @Column(name = "cmp_state")
    private String state;
    @Column(name = "cmp_country")
    private String country;
    @Column(name = "cmp_bname")
    private String bank;
    @Column(name = "cmp_bbranch")
    private String bankBranch;
    @Column(name = "cmp_bifce")
    private String bankIfce;
    @Column(name = "cmp_baccountno")
    private String bankAccNO;
    @Column(name = "cmp_logo")
    private String Logo;
    public CompanyData(String name, String address1, String addres2, String phone, String email, String website,
            String gstNo, String city, String state, String country, String bank, String bankBranch, String bankIfce,
            String bankAccNO, String logo) {
        Name = name;
        Address1 = address1;
        Addres2 = addres2;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.gstNo = gstNo;
        City = city;
        this.state = state;
        this.country = country;
        this.bank = bank;
        this.bankBranch = bankBranch;
        this.bankIfce = bankIfce;
        this.bankAccNO = bankAccNO;
        Logo = logo;
    }
    public CompanyData() {
		super();
		// TODO Auto-generated constructor stub
	}


    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAddress1() {
        return Address1;
    }
    public void setAddress1(String address1) {
        Address1 = address1;
    }
    public String getAddres2() {
        return Addres2;
    }
    public void setAddres2(String addres2) {
        Addres2 = addres2;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getGstNo() {
        return gstNo;
    }
    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }
    public String getBankIfce() {
        return bankIfce;
    }
    public void setBankIfce(String bankIfce) {
        this.bankIfce = bankIfce;
    }
    public String getBankAccNO() {
        return bankAccNO;
    }
    public void setBankAccNO(String bankAccNO) {
        this.bankAccNO = bankAccNO;
    }
    public String getLogo() {
        return Logo;
    }
    public void setLogo(String logo) {
        Logo = logo;
    }
}
