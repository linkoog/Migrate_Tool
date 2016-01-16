package com.migrate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void config() {
		Configuration  config  = new Configuration();
		assertNotEquals(null, config.srcConn);
		assertNotEquals(null, config.destConn);
		
	}

}
