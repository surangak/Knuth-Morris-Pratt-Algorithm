package de.hskarlsruhe.algolab.testing;

import java.io.IOException;

import org.junit.Test;

import de.hskarlsruhe.algolab.implementation.AdvancedFileProvider;
import de.hskarlsruhe.algolab.implementation.SimpleFileProvider;
import de.hskarlsruhe.algolab.implementation.KnuthMorrisPratt;
import de.hskarlsruhe.algolab.implementation.StringProvider;
import de.hskarlsruhe.algolab.interfaces.ISearchAlgorithm;

import junit.framework.TestCase;

/**
 * This class implements the Unittests for the KnuthMorrisPratt Class.
 * 
 * @author Mario Kaufmann
 * 
 */
public class KnuthMorrisPrattTest extends TestCase {

	String fileName = "suchtext.txt";

	ISearchAlgorithm searchAlgorithm = null;

	public KnuthMorrisPrattTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		searchAlgorithm = new KnuthMorrisPratt();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testPatternAtBegin() {
		int result = searchAlgorithm.find(new StringProvider(
				"hallodiesisteintest"), new StringProvider("hallo"));
		assertEquals(result, 0);
	}

	@Test
	public void testPatternInTheMiddle() {
		int result = searchAlgorithm.find(new StringProvider(
				"hallodiesisteintest"), new StringProvider("ist"));
		assertEquals(result, 9);
	}

	@Test
	public void testPatternAtEnd() {
		int result = searchAlgorithm.find(new StringProvider(
				"hallodiesisteintest"), new StringProvider("test"));
		assertEquals(result, 15);
	}

	@Test
	public void testPatternNotInText() {
		int result = searchAlgorithm.find(new StringProvider(
				"hallodiesisteintest"), new StringProvider("kartoffel"));
		assertEquals(result, -1);
	}

	@Test
	public void testEmptyText() {
		int result = searchAlgorithm.find(new StringProvider(""),
				new StringProvider("kartoffel"));
		assertEquals(result, -1);
	}

	@Test
	public void testEmptyPattern() {
		int result = searchAlgorithm.find(new StringProvider(
				"hallodiesisteintest"), new StringProvider(""));
		assertEquals(result, -1);
	}

	@Test
	public void testLastCharacterDifferent() {
		int result = searchAlgorithm.find(new StringProvider(
				"hallodiesisteintest"), new StringProvider(
				"hallodiesisteintesd"));
		assertEquals(result, -1);
	}

	@Test
	public void testFindingInFileNoMatch() throws IOException {
		int result = searchAlgorithm.find(new SimpleFileProvider(
				fileName), new StringProvider(
				"hallodiesisteintesd"));
		assertEquals(result, -1);
	}

	@Test
	public void testFindingInFileMath() throws IOException {
		int result = searchAlgorithm.find(new SimpleFileProvider(
				fileName), new StringProvider(
				"das"));
		assertEquals(result, 6);
	}

	@Test
	public void testFindingInFileEmptyPattern() throws IOException {
		int result = searchAlgorithm.find(new SimpleFileProvider(
				fileName),
				new StringProvider(""));
		assertEquals(result, -1);
	}

	// TESTING THE ADVANCED FILE PROVIDER
	@Test
	public void test1() throws IOException {
		int result = searchAlgorithm.find(new AdvancedFileProvider(
				fileName), new StringProvider(
				"h"));
		assertEquals(0, result);
	}

	@Test
	public void test2() throws IOException {
		int result = searchAlgorithm.find(new AdvancedFileProvider(
				fileName), new StringProvider(
				"a"));
		assertEquals(1, result);
	}

	@Test
	public void testFindingInFileNoMatchAdvanced() throws IOException {
		int result = searchAlgorithm.find(new AdvancedFileProvider(
				fileName), new StringProvider(
				"hallodiesisteintesd"));
		assertEquals(-1, result);
	}

	@Test
	public void testFindingInFileMatchAdvanced() throws IOException {
		int result = searchAlgorithm.find(new AdvancedFileProvider(
				fileName), new StringProvider(
				"das"));
		assertEquals(6, result);
	}

	@Test
	public void testFindingInFileEmptyPatternAdvanced() throws IOException {
		int result = searchAlgorithm.find(new AdvancedFileProvider(
				fileName),
				new StringProvider(""));
		assertEquals(-1, result);
	}

}
