package de.hskarlsruhe.algolab.testing;

import junit.framework.TestCase;

import org.junit.Test;

import de.hskarlsruhe.algolab.implementation.AdvancedFileProvider;

/**
 * This class implements the Unittests for the KnuthMorrisPratt Class.
 * 
 * @author Mario Kaufmann
 * 
 */
public class AdvancedFileProviderTest extends TestCase {

	AdvancedFileProvider fileProvider;
	
	public AdvancedFileProviderTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		fileProvider = new AdvancedFileProvider("C:\\users\\t60\\desktop\\suchtext.txt");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testSingleCharAtBegin() {
		char c = fileProvider.charAt(0);		
		assertEquals(c, "hallo".charAt(0));
	}
	
	@Test
	public void testSingleCharAtMiddle() {
		char c = fileProvider.charAt(1);
		assertEquals(c, "hallo".charAt(1));
	}
	
	@Test
	public void testSingleCharAtEnd() {
		char c = fileProvider.charAt(1);
		assertEquals(c, "hallo".charAt(1));
	}
	
	
	
	@Test
	public void test3() {
		char c = fileProvider.charAt(2);		
		assertEquals(c, "hallo".charAt(2));
	}
	
	
	// LÄNGE TESTEN
	@Test
	public void testLength() {
		int l = fileProvider.length();
		assertEquals(l, 124);
	}
	
}
