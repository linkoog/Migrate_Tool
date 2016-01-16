package com.migrate;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		Connection  srcConnection = configuration.srcConn;
		Connection  destConnection = configuration.destConn;
	}

}
