package de.hskarlsruhe.algolab.interfaces;

/**
 * This Interface represents a Datasource.
 * 
 * @author Mario Kaufmann
 * 
 */
public interface IDataProvider {

	/**
	 * This method returns the length of the Datasource.
	 * @return The length of the Datasource.
	 */
	public int length();

	/**
	 * @param position Position of the requested Char.
	 * @return The requested Char.
	 */
	public char charAt(int position);

}
