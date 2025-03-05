package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Product;

@Repository	//DI를 이용을 위해 사용 SpringBoot에서 new할 수 있게 Component로 만들어준다.
			//Service 에 Component 대신 service를 이용했듯이 Repository로 이용 가능하다.
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	
	public List<Product> getAllProducts() throws Exception{
		
		Class.forName(DB_DRIVER);

		String sql = "select * from product";
		
		try(
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
				){
			
			List<Product> list = new ArrayList();
			
			while(rs.next()) {
				
				int prodcode = rs.getInt("prodcode");
				String prodname = rs.getString("prodname");
				String pimg = rs.getString("pimg");
				int price = rs.getInt("price");
				
				list.add(new Product(prodcode, price, prodname, pimg));
			}
			
			return list;
			
			
			
		}
		
		
	}

}
