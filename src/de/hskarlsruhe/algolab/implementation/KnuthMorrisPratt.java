package de.hskarlsruhe.algolab.implementation;

import de.hskarlsruhe.algolab.interfaces.IDataProvider;
import de.hskarlsruhe.algolab.interfaces.ISearchAlgorithm;

/**
 * 
 * This class implements the Knuth Morris Pratt Pattern Matching Algorithm.
 * 
 * @author T60
 * 
 */
public class KnuthMorrisPratt implements ISearchAlgorithm {

	/**
	 * This method takes a search pattern and creates a Prefix Table out of it,
	 * which can be used for the Knuth-Morris-Pratt Algorithm.
	 * 
	 * @param pattern The search pattern.
	 * @return The prefix list.
	 */
	private int[] getPrefixList(IDataProvider pattern) {
		int[] prefixList = new int[pattern.length() + 1];
		int patternPosition = 0;
		int prefixLength = -1;

		// set 1. element to -1
		prefixList[patternPosition] = prefixLength;

		// iterate over the entire pattern
		while (patternPosition < pattern.length()) {
			
			// ?
			while (prefixLength >= 0
					&& pattern.charAt(prefixLength) != pattern
							.charAt(patternPosition)) {
				prefixLength = prefixList[prefixLength];
			}

			// an dieser Stelle ist prefix_len=-1 oder
			// oder pattern[prefix_len] == pattern[i]

			// unter dem n�chsten Zeichen im Muster den gefundenen Wert
			// (mindestens 0) in die Pr�fix-Tabelle eintragen
			patternPosition++;
			prefixLength++;
			prefixList[patternPosition] = prefixLength;
		}
		return prefixList;
	}

	@Override
	public int find(IDataProvider text, IDataProvider pattern) {

		// abort if text or pattern is empty
		if (pattern.length() == 0 || text.length() == 0) {
			return -1;
		}

		int textPosition = 0; // pos im Text
		int patternPosition = 0; // pos im pattern

		// create the prefix table
		int[] prefixes = getPrefixList(pattern);

		// iterate over the text
		while (textPosition < text.length()) {
			// muster verschieben, bis Text mit Muster übereinstimmt
			while (patternPosition >= 0
					&& text.charAt(textPosition) != pattern
							.charAt(patternPosition)) {
				patternPosition = prefixes[patternPosition];
			}

			textPosition++;
			patternPosition++;

			// return result if end of pattern has been reached
			if (patternPosition == pattern.length()) {
				patternPosition = prefixes[patternPosition];

				return (textPosition - pattern.length()); // anfangsposition!
			}
		}
		return -1;

	}

}