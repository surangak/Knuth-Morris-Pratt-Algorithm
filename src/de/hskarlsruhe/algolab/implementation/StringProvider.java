package de.hskarlsruhe.algolab.implementation;

import de.hskarlsruhe.algolab.interfaces.IDataProvider;

public class StringProvider implements IDataProvider{
	
	private String text;

	public StringProvider(String text) {
		this.text = text;
	}

	@Override
	public char charAt(int position) {
		return this.text.charAt(position);
	}

	@Override
	public int length() {
		return this.text.length();
	}

	@Override
	public void append(String character) {
		text.concat(character);
	}

}
