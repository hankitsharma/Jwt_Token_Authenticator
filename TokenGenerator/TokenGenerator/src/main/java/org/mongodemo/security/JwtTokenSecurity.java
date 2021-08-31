package org.mongodemo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mongodemo.demoservice.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenSecurity{

	public Map<String, String> tokenGenerator(User user){
		String token = Jwts.builder().setIssuer("SAM").setIssuedAt(new Date()).setSubject(user.getUsername()).signWith(SignatureAlgorithm.HS256 , "A secret").compact();
		Map <String,String> map = new HashMap<String, String>();
		map.put("token", token);
		map.put("message", "it is a secret dont tell anyone");
		return map;
	}
}
