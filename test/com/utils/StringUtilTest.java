package com.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isBlank() {
		assertEquals(true, StringUtil.isBlank(null));
		assertEquals(true, StringUtil.isBlank(""));
		assertEquals(true, StringUtil.isBlank("    "));
		assertEquals(true, StringUtil.isBlank("null"));
		assertEquals(false, StringUtil.isBlank("test"));
	}
	
	@Test
	public void isNotBlank(){
		assertEquals(false, StringUtil.isNotBlank(null));
		assertEquals(false, StringUtil.isNotBlank(""));
		assertEquals(false, StringUtil.isNotBlank("    "));
		assertEquals(false, StringUtil.isNotBlank("null"));
		assertEquals(true, StringUtil.isNotBlank("test"));
	}

}
