package com.migrate;

import java.io.File;
import java.net.URLDecoder;
import java.sql.Connection;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.database.ConnectionUtil;
import com.utils.StringUtil;

public class Configuration {
	
	String      xmlPath;
	Connection  srcConn ;
	Connection  destConn;
	
	public   Configuration() {
		xmlPath = URLDecoder.decode(Configuration.class.getResource("/migrate-config.xml").getFile()) ;
		try {
			parseXml();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public   Configuration(String xmlFilePath) {
		if (StringUtil.isNotBlank(xmlFilePath)) {
			xmlPath = xmlFilePath;
			try {
				parseXml();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private  void  parseXml() throws DocumentException {
		File  xmlFile = null;
		if(StringUtil.isNotBlank(xmlPath) && (xmlFile = new File(xmlPath)).exists()){
			SAXReader saxReader = new SAXReader();
			Document   document = saxReader.read(xmlFile);
			
			if (document != null) {
				Element  root  = document.getRootElement();
				Element  srcDB = (Element) root.selectSingleNode("database[@type='resource']");
				Element  destDB = (Element) root.selectSingleNode("database[@type='destination']");
				if (srcDB != null && destDB != null) {
					System.out.println("111");
					srcConn = ConnectionUtil.createConn(srcDB.selectSingleNode("property[@name='dbType']").getText(),
							srcDB.selectSingleNode("property[@name='url']").getText(),
							srcDB.selectSingleNode("property[@name='user']").getText(),
							srcDB.selectSingleNode("property[@name='passwd']").getText());

					destConn = ConnectionUtil.createConn(destDB.selectSingleNode("property[@name='dbType']").getText(),
												 destDB.selectSingleNode("property[@name='url']").getText(),
												 destDB.selectSingleNode("property[@name='user']").getText(),
												 destDB.selectSingleNode("property[@name='passwd']").getText());
					
				}
				
				
			}
		}
		
	}
	 
	
	
}
