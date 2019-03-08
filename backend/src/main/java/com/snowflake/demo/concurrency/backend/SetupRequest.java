package com.snowflake.demo.concurrency.backend;

import lombok.Getter;
import lombok.Setter;

public class SetupRequest {
	@Getter @Setter String user;
	@Getter @Setter String account;
	@Getter @Setter String privateKey;
}
