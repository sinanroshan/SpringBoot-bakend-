package net.springboot.backend.controller;


import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.repository.CustomerRepository;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class userAuth {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(path="/chek/{uname}",method = RequestMethod.GET)
	public boolean userid(@PathVariable String uname) {
				byte[] decodedString=Base64.getDecoder().decode(uname);
				String decodeUname = new String(decodedString);
			var key= customerRepository.findByPhoneNo(decodeUname);
			boolean ans = key.isEmpty();
			if (ans==false) {
				return true;
			}
			else {
				return false;
			}
	}
	
	@RequestMapping(path="/AuthGuard/{key}",method = RequestMethod.GET)
	public String Authenticate(@PathVariable String key) {
		byte[] decoded=Base64.getDecoder().decode(key);
		String securityKey= new String(decoded);
		String[] split=securityKey.split(":");
		String username=split[0];
		String password = split[1];  
		String loginKey= customerRepository.login(username,password);
		if (loginKey==null){
			return "error";
		}
		else {
			return generateToken(username, password);
			//return HttpStatus.OK;
		}
	}
	
	public String generateToken(String uname, String pass){
		String Tkey = customerRepository.getTokenKey(uname, pass);
		System.out.println(Tkey);
		String[] split=Tkey.split(",");
		String key1=split[0];
		String key2=":"+split[1];
				String tokenKey = key1+key2;
				tokenKey=tokenKey+"key";
				String token= Base64.getEncoder().encodeToString(tokenKey.getBytes());
				setTokenKey(token, uname, pass);
		return (token);
	}
	public String generateUserToken(String uname, String pass){
		String key1=uname;
		String key2=":"+pass;
				String tokenKey = key1+key2;
				tokenKey=tokenKey+"key";
				String token= Base64.getEncoder().encodeToString(tokenKey.getBytes());
				setTokenKey(token, uname, pass);
		return (token);
	}
	public void setTokenKey(String Token, String Uname, String Pass) {
		customerRepository.setSecureToken(Token, Uname, Pass);
	}
	@RequestMapping(path="/user/{token}",method = RequestMethod.GET)
	public String[] user(@PathVariable String token) {
				byte[] firstdecoded=Base64.getDecoder().decode(token);
				byte[] seconddecoded=Base64.getDecoder().decode(firstdecoded);
				String decodedToken = new String(seconddecoded);
				String[] split=decodedToken.split(":");
						String key= split[0];
			String a=customerRepository.getcustomer(key);
			String[] split1=a.split(",");
			return split1;
	}
	
	@RequestMapping(path="/SignUp/{cfname}/{csname}/{cphone}/{cemail}/{cpass1}",method = RequestMethod.GET)
	public String Register(@PathVariable String cfname, @PathVariable String csname , @PathVariable String cphone , @PathVariable String cemail , @PathVariable String cpass1) {
		
		byte[] dfname=Base64.getDecoder().decode(cfname);
		String fnmae = new String(dfname);
		
		byte[] dsname=Base64.getDecoder().decode(csname);
		String sname = new String(dsname);
		
		byte[] dphone=Base64.getDecoder().decode(cphone);
		String phone = new String(dphone);
		
		byte[] demail=Base64.getDecoder().decode(cemail);
		String email = new String(demail);
		
		byte[] dpass1=Base64.getDecoder().decode(cpass1);
		String pass1 = new String(dpass1);
		
		customerRepository.DoRegister(fnmae, sname, phone, email, pass1);
		String token = generateToken(phone, pass1);
	 	setTokenKey(token,phone,pass1);
	 		return token;
		}
	
	@RequestMapping(path="/setAdd/{ctoken}/{cfname}/{cphone}/{cArea}/{cHouse_n}/{cPincode}/{cLandmark}/{cTown_city}",method = RequestMethod.GET)
	public String setAdd(@PathVariable String ctoken, @PathVariable String cfname , @PathVariable String cphone , @PathVariable String cArea , @PathVariable String cHouse_n, @PathVariable String cPincode , @PathVariable String cLandmark, @PathVariable String cTown_city) {
		
		byte[] dtoken=Base64.getDecoder().decode(ctoken);
		String token = new String(dtoken);
		
		byte[] dfname=Base64.getDecoder().decode(cfname);
		String fname = new String(dfname);
		
		byte[] dphone=Base64.getDecoder().decode(cphone);
		String phone = new String(dphone);
		
		byte[] dArea=Base64.getDecoder().decode(cArea);
		String Area = new String(dArea);
		
		byte[] dHouse_n=Base64.getDecoder().decode(cHouse_n);
		String House_n = new String(dHouse_n);
		
		byte[] dPincode=Base64.getDecoder().decode(cPincode);
		String Pincode = new String(dPincode);
		
		byte[] dLandmark=Base64.getDecoder().decode(cLandmark);
		String Landmark = new String(dLandmark);
		
		byte[] dTown_city=Base64.getDecoder().decode(cTown_city);
		String Town_city = new String(dTown_city);
		
		String[] split=token.split(":");
		String uname=split[0];
		customerRepository.SetAddress(uname,fname,phone,Area,House_n,Pincode,Landmark,Town_city);
		
	 		return "sucess";
		}
	
	@RequestMapping(path="/getAdd/{token}",method = RequestMethod.GET)
	public String[] Address(@PathVariable String token) {
				byte[] firstdecoded=Base64.getDecoder().decode(token);
				byte[] seconddecoded=Base64.getDecoder().decode(firstdecoded);
				String decodedToken = new String(seconddecoded);
				String[] split=decodedToken.split(":");
						String key= split[0];
			String a=customerRepository.getAdd(key);
			String[] split1=a.split(",");
			return split1;
			
	}
	
	@RequestMapping(path="/order/{token}/{no_products}/{total_price}/{prod_id}/{prod_name}/{prod_qty}/{p_category}/{p_price}/{p_mrp}/{p_tprice}",method = RequestMethod.GET)
	public HttpStatus SaveOrder(@PathVariable String token, @PathVariable String no_products, @PathVariable String total_price,@PathVariable String prod_id,
		@PathVariable String prod_name, @PathVariable String prod_qty,@PathVariable String p_category,@PathVariable String p_price,@PathVariable String p_mrp,@PathVariable String p_tprice) {
				byte[] firstdecoded=Base64.getDecoder().decode(token);
				byte[] seconddecoded=Base64.getDecoder().decode(firstdecoded);
				String decodedToken = new String(seconddecoded);
				String[] split=decodedToken.split(":");
				String phone= split[0];
				int qty=Integer.valueOf(no_products);
				String[] pids=splitValue(prod_id, qty);
				String[] pnames=splitValue(prod_name, qty);
				String[] pqtys=splitValue(prod_qty, qty);
				String[] pcategorys=splitValue(p_category, qty);
				String[] prices=splitValue(p_price, qty);
				String[] mrps=splitValue(p_mrp, qty);
				String[] tprices=splitValue(p_tprice, qty);
				
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String date=(formatter.format(calendar.getTime()));
				//Date date= Date.valueOf(d);
						
				String status="Order confirmed"; 
				customerRepository.saveOrder(phone, qty, total_price,date, status);
				String[] s= customerRepository.getInv();
				String invo_no = s[(s.length)-1];
				customerRepository.saveOrderAdress(phone, invo_no);
				
				for (int i=0; i<qty; i++) {
					String pid = pids[i];
					String pname=pnames[i];
					String pqty=pqtys[i];
					String pcategory=pcategorys[i];
					String price=prices[i];
					String mrp=mrps[i];
					String tprice=tprices[i];
					customerRepository.saveBill(invo_no,pid,pname,pqty,pcategory,price,mrp,tprice,status);
				}
				return HttpStatus.ACCEPTED;
			}
	
	public String[] splitValue(String key, Integer qty){
		String[] split=key.split(",");
		return split;
	}

	@RequestMapping(path="/getOrder/{token}",method = RequestMethod.GET)
	public String[][] order(@PathVariable String token) {
				byte[] firstdecoded=Base64.getDecoder().decode(token);
				byte[] seconddecoded=Base64.getDecoder().decode(firstdecoded);
				String decodedToken = new String(seconddecoded);
				String[] split=decodedToken.split(":");
						String key= split[0];
			String[][] a=customerRepository.getOrder(key);
			return a;
	}
	
	@RequestMapping(path="/OrderList/{inv_no}",method = RequestMethod.GET)
	public List<String[]> billlist(@PathVariable String inv_no) {
		return customerRepository.getProdList(inv_no);
	}
	@RequestMapping(path="/bill/{inv_no}",method = RequestMethod.GET)
	public List<String[]> bill(@PathVariable String inv_no) {
		return customerRepository.getBill(inv_no);
	}

	@RequestMapping(path="/ItemStatus/{inv_no}/{item}/{status}",method = RequestMethod.GET)
	public HttpStatus changeItemSts(@PathVariable String inv_no, @PathVariable String item,@PathVariable String status) {
		customerRepository.OrderItemStatus(inv_no,item,status);
		chekOrder( inv_no);
		return HttpStatus.ACCEPTED;
	}
	
	public void chekOrder(String invNo){
		List<String> status= customerRepository.chekorderStatus(invNo);
		boolean cancelOrder= status.stream().allMatch(str -> str.equals("Order Cancelled"));
		if(cancelOrder){customerRepository.OrderStatus(invNo, "Order Cancelled");}
	}

	@RequestMapping(path="/OrderStatus/{inv_no}/{status}",method = RequestMethod.GET)
	public HttpStatus changeOrder(@PathVariable String inv_no,@PathVariable String status) {
		customerRepository.OrderStatus(inv_no,status);
		customerRepository.setOrderItemStatus(inv_no, status);
		return HttpStatus.ACCEPTED;
	}
}

