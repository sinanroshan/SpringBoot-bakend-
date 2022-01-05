package net.springboot.backend.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.repository.EpmloyeeRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ConsoleAuth {
    
    @Autowired
    private EpmloyeeRepository epmloyeeRepository;

	@RequestMapping(path="/AuthGuard/{key}",method = RequestMethod.GET)
	public String Authenticate(@PathVariable String key) {
		byte[] decoded=Base64.getDecoder().decode(key);
		String securityKey= new String(decoded);
		String[] split=securityKey.split(":");
		String username=split[0];
		String password = split[1];  
		String loginKey= epmloyeeRepository.EmpLogin(username,password);
		if (loginKey==null){
			return "error";
		}
		else {
			return generateToken(username, password);
			//return HttpStatus.OK;
		}
	}
	
	public String generateToken(String uname, String pass){
		String Tkey = epmloyeeRepository.getTokenKey(uname, pass);
		System.out.println(Tkey);
		String[] split=Tkey.split(",");
		String key1=split[0];
		String key2=":"+split[1];
				String tokenKey = key1+key2;
				tokenKey=tokenKey+"key";
				String token= Base64.getEncoder().encodeToString(tokenKey.getBytes());
		return (token);
	}
	
}
