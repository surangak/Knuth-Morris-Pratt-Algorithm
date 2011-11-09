package de.hskarlsruhe.algolab.interfaces;

/**
 * This Interface represents a Datasource.
 * 
 * @author Mario Kaufmann
 * 
 */
public interface IDataProvider {

	/**
	 * @return The length of the Datasource.
	 */
	public int length();

	public char charAt(int position);

}
