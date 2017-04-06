package com.rex.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.FileSystemAlreadyExistsException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {

	private static String filepath;
	
	static{
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
	}
	
	public static Document getDocument() throws Exception{

		SAXReader reader = new SAXReader();
		Document document=reader.read(filepath);
		return document;
	}
	
	public static void write2Xml(Document document) throws Exception{
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");

		
		File file = new File(filepath);
		
		XMLWriter writer = new XMLWriter(new FileWriter(file), format);

		writer.write(document);
		writer.close();
	}
}
