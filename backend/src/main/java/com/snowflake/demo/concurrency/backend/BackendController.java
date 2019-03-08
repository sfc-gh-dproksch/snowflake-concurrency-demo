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

	/**
	*
	* Setup / Teardown section
	*
	**/
	@PostMapping("/backend/teardown")
	public String postSetup() {
		/**
		*
		*  Tear down the Demo environment
		*
		*  1.  Destroy Tables, Views, Shares, Stages, etc.
		*  2.  Destroy Warehouses
		*  3.  Destroy Database(s)
		*  4.  Remove Users
		*
		**/	

		// Use existing Demo object
		// - Exercise methods to accomplish teardown.
		// 
		return ("Environment successfully tore down");
	}

	@PostMapping("/backend/setup")
	public String postSetup(
		@RequestParam(value="account", defaultValue="none") String account
		, @RequestParam(value="user", defaultValue="user") String user
		, @RequestParam(value="privateKey", defaultValue="none") String privKey
		) {
		/**
		*
		* Setup the Demo environment
		* 1. Need Account, User, and Private Key to make 
		*    connection to Snowflake.
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
		
		// Create new Demo Object
		// Create Connection
		// Create Snowflake Objects
		// 1.  DB
		// 2.  WH
		// 3.  Users
		// 4.  Other stuff?
		//
		// Demo s = new Demo();
		// Set the attributes
		// Execute the methods
	
		return ("Create Environment");
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

	/**
	*
	*  Begin ETL Section
	*
	**/
	@PostMapping("/backend/etl")
	public String postETL(
		@RequestParam(value="etl", defaultValue="on") String etl
		) {

		boolean good = false;
		String resultString = "Invalid Choice: " + etl.trim() +
			" Valid choices:  ON OFF";
		if (etl.equalsIgnoreCase("ON")) {
			good=true;
			// start the ETL part of the demo
		}
		if (etl.equalsIgnoreCase("OFF")) {
			good=true;
			// stop the ETL part of the demo
		}
		if (good) {
			resultString = "OK:  200";
		}
		return resultString.trim();
	}


	/**
	*
	*  Begin Data Science Section
	*
	**/

	@PostMapping("/backend/ds")
	public String postDS(
		@RequestParam(value="ds", defaultValue="on") String ds
		) {

		boolean good = false;
		String resultString = "Invalid Choice: " + etl.trim() +
			" Valid choices:  ON OFF";
		if (ds.equalsIgnoreCase("ON")) {
			good=true;
			// start the Data Science part of the demo
		}
		if (ds.equalsIgnoreCase("OFF")) {
			good=true;
			// stop the Data Science part of the demo
		}
		if (good) {
			resultString = "OK:  200";
		}
		return resultString.trim();
	}


	/**
	*
	*  Begin Analytical Query Section
	*
	**/
}
