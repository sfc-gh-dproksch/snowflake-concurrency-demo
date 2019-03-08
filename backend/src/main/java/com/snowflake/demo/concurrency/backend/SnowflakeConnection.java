package com.snowflake.demo.concurrency.backend;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

import net.snowflake.client.jdbc.SnowflakeDriver;
import java.sql.Connection;
import java.sql.DriverManager;

/**
*
* Create a connection to Snowflake for a given
* - Account
* - Private Key
* - User
*
*/
public class SnowflakeConnection {
	@Getter @Setter private String account;
	@Getter @Setter private String privateKey; 
	@Getter @Setter private String user;
	@Getter Connection conn;

	/**
	*
	* Load the Snowflake driver class
	*
	*/
	public SnowflakeConnection() {
		try {
			Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	*
	* Close the connection to Snowflake
	*
	*/
	public boolean closeConnection() {
		conn.close();
	}

	/**
	*
	* Open the connection to Snowflake
	*
	*/
	public boolean makeConnection() {
		boolean rc = false;

		// Build out the URL for the connection
		StringBuffer url = new StringBuffer();
		url = url.append("jdbc:snowflake://")
			.append(account.trim())
			.append(".snowflakecomputing.com");
	
		// Build the necessary properties
		Properties prop = new Properties();
		prop.put("user",user.trim());
		prop.put("account",account.trim());
		prop.put("password",privateKey.trim());

		/*
		*
		* Try the connection
		*
		*/
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
