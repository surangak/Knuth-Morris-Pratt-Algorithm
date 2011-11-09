package de.hskarlsruhe.algolab.implementation;

import de.hskarlsruhe.algolab.interfaces.IDataProvider;
import de.hskarlsruhe.algolab.interfaces.ISearchAlgorithm;

/**
 * This class implements a Naive Pattern Matching Algorithm.
 * 
 * @author Mario Kaufmann
 * 
 */
public class Naive implements ISearchAlgorithm {

	@Override
	public int find(IDataProvider text, IDataProvider pattern) {

		int textLength = text.length();
		int patternLength = pattern.length();

		// abort if the pattern or the string is empty
		if (textLength == 0 || patternLength == 0) {
			return -1;
		}

		// iterate over the text
		for (int i = 0; i <= textLength - patternLength; i++) {
			int j = 0;

			// go to next char as long as chars match
			while (j < patternLength && text.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}

			// found the pattern
			if (j == patternLength) {
				return i;
			}
		}

		// pattern has not been found
		return -1;
	}

}