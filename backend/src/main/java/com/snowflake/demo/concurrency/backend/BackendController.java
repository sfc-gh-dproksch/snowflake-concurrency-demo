package com.snowflake.demo.concurrency.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
public class BackendController {

	@PostMapping("/backend/setup")
	public String postSetup(
		@RequestParam(value="account", defaultValue="none") String account
		, @RequestParam(value="user", defaultValue="user") String user
		, @RequestParam(value="privateKey", defaultValue="none") String privKey
		) {
		/**
		*
		* Setup the Demo environment
		* 1. Need Account, User, and Private Key to make connection to Snowflake.
		*
		* 2. Create the needed Databases
		*    -  X
		*    -  Y
		*    -  Z
		*
		* 3. Create the needed warehouses
		*    - DEMO_ETL
		*    - DEMO_DS
		*    - DEMO_BI1  MCW(1,6)
		*    - DEMO_BI2  MCW(2,6)
		*
		**/
		
		// Create new Setup Object
		// Create Connection
		// Create Snowflake Objects
		// 1.  DB
		// 2.  WH
		// 3.  Users
		// 4.  Other stuff?
		return ("Connected to Warehouse: " + wh);
	}

	/*
	Get a list of all the warehouses
	*/
	@GetMapping("/backend/warehouses")
	public String getWarehouses() {
		return ("List of Warehouses!");
	}

	@GetMapping("/backend/warehouse")
	public String getWarehouse(@RequestParam(value="wh", 
		defaultValue="a_warehouse") String wh) {
		return ("Warehouse: " + wh);
	}

	@PostMapping("/backend/warehouse")
	public String postWarehouse(
		@RequestParam(value="wh", defaultValue="a_warehouse") String wh
		, @RequestParam(value="size", defaultValue="XS") String size
		) {
		return ("Creating Warehouse: " + wh);
	}
}
