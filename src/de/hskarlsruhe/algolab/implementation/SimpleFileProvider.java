package de.hskarlsruhe.algolab.implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import de.hskarlsruhe.algolab.interfaces.IDataProvider;

public class SimpleFileProvider implements IDataProvider {
	
	private String text;
	
	public SimpleFileProvider(String fileName) throws IOException {
		
		Reader in = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		BufferedReader br = new BufferedReader(in); 
		
		// Reader in = new InputStreamReader(new FileInputStream("C:\\users\\t60\\desktop\\suchtext.txt"), "UTF-8");
		/*
		FileReader fr = new FileReader("C:\\users\\t60\\desktop\\suchtext.txt"); 
		BufferedReader br = new BufferedReader(fr); 
		*/
		
		String s; 
		StringBuilder contents = new StringBuilder();
		
		// read the entire file into memory
		while((s = br.readLine()) != null) { 
			contents.append(s);
		} 
		
		br.close(); 
		
		text = contents.toString();
		
	}

	@Override
	public char charAt(int position) {
		return text.charAt(position);
	}

	@Override
	public int length() {
		return text.length();
	}

}
