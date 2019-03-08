package com.snowflake.demo.concurrency.backend;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import net.snowflake.client.jdbc.SnowflakeDriver;
import java.sql.Connection;
import java.sql.DriverManager;

public class SnowflakeConnection {
	@Getter @Setter private String account;
	@Getter @Setter private String privateKey; 
	@Getter @Setter private String user;
	@Getter Connection conn;

	public SnowflakeConnection() {
		try {
			Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public boolean closeConnection() {
		conn.close();
	}

	public boolean makeConnection() {
		boolean rc = false;
		StringBuffer url = new StringBuffer();
		url = url.append("jdbc:snowflake://")
			.append(account.trim())
			.append(".snowflakecomputing.com");
		Properties prop = new Properties();
		prop.put("user",user.trim());
		prop.put("account",account.trim());
		prop.put("password",privateKey.trim());

		System.err.println(prop.toString());

		try {
			conn = DriverManager.getConnection(url.toString(), prop);
			System.err.println("Life is good when connected");
			rc = true;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			rc = false;
		}

		return rc;
		
	}

}
