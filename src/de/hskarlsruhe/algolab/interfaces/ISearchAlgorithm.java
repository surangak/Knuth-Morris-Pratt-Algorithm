package de.hskarlsruhe.algolab.interfaces;

/**
 * The interface for a Search Algorithm.
 * 
 * @author Mario Kaufmann
 * 
 */
public interface ISearchAlgorithm {
	/**
	 * This method takes a text and a pattern and returns the first occurence of
	 * the pattern in the text.
	 * 
	 * @param text The text that will be searched for the pattern.
	 * @param pattern The pattern that will be searched for.
	 * @return
	 */
	public int find(IDataProvider text, IDataProvider pattern);
}
