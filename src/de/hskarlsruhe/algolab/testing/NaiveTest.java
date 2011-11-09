package de.hskarlsruhe.algolab.testing;

import de.hskarlsruhe.algolab.implementation.Naive;

/**
 * This class implements the Unittests for the Naive Pattern Matching class.
 * @author T60
 *
 */
public class NaiveTest extends KnuthMorrisPrattTest {
	
	public NaiveTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		searchAlgorithm = new Naive();
	}
	
}