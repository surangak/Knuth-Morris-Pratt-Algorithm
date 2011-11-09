package de.hskarlsruhe.algolab.implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import de.hskarlsruhe.algolab.interfaces.IDataProvider;

/**
 * This class implements an Advanced Filereader. In contrast to the Simple File
 * Provider it can work with files which exceed the heap limit.
 * 
 * @author Mario Kaufmann
 */
public class AdvancedFileProvider implements IDataProvider {

	BufferedReader file;
	int currentPosition = 0;
	char currentCharacter;
	int length;
	String fileName;

	/**
	 * This constructor sets up the Advanced FileProvider.
	 * 
	 * @param fileName
	 *            The name of the file which should be read.
	 * @throws IOException
	 */
	public AdvancedFileProvider(String fileName) throws IOException {
		this.fileName = fileName;
		readFile(fileName);

		length = getLength();
	}

	/**
	 * This method takes a Filename and returns a Filebuffer.
	 * 
	 * @param fileName
	 *            Name of the file to be read.
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void readFile(String fileName) throws UnsupportedEncodingException,
			FileNotFoundException, IOException {

		// get a handle to the file
		Reader in = new InputStreamReader(new FileInputStream(fileName),
				"UTF-8");

		// make it buffered for performance reasons
		file = new BufferedReader(in);

		// read first character
		currentCharacter = (char) file.read();

		// reset the position pointer
		currentPosition = 0;
	}

	@Override
	public char charAt(int newPosition) {

		// catch OutOfBounds errors early
		if (newPosition < 0 || newPosition > Integer.MAX_VALUE) {
			throw new IndexOutOfBoundsException();
		}

		// calculate the offset
		int delta = newPosition - currentPosition;

		// we need to go forwards
		if (delta > 0) {
			while (delta != 0) {
				try {
					currentCharacter = (char) file.read();
					currentPosition++;
				} catch (IOException e) {
					e.printStackTrace();
					throw new IndexOutOfBoundsException();
				}
				delta--;
			}
			return currentCharacter;

			// we are aldreay there
		} else if (delta == 0) {
			return currentCharacter;

			// we need to go backwards
		} else if (delta < 0) {

			// reset the file
			try {
				readFile(this.fileName);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// go forward
			while (delta != 0) {
				try {
					currentCharacter = (char) file.read();
					currentPosition++;
				} catch (IOException e) {
					e.printStackTrace();
				}
				delta++;
			}

			return currentCharacter;
		}

		// this code should not be reached
		return 0;

	}

	@Override
	public int length() {
		return length;
	}

	/**
	 * This method returns the length of the filebuffer.
	 * 
	 * @return The length of the filebuffer in char.
	 */
	private int getLength() {
		int length = 0;

		// iterate over file and increment length counter
		try {
			while (file.read() != -1) {
				length++;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// reset the buffer
		try {
			readFile(fileName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return length;
	}

}
