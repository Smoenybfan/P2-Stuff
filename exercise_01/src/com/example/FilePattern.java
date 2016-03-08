package com.example;

import java.io.File;
import java.io.FileFilter;

/** Filters file names using command-line wildcards.
 * <P>
 * <tt>*</tt> matches any number of characters.
 * <tt>?</tt> matches exactly one characters.
 * <P>
 * <b>Example:</b> 
 * <tt>*.txt</tt> matches all text files;  
 * <tt>cat??.jpg</tt> matches all images that start
 * with <i>cat</i> and got two more characters. 
 * 
 * @author David Bösiger
 *
 */

/*
 * @Mathias 
 * Your solution passes all tests which we had provided.
 * Additionally, you even wrote two test cases of your own. 
 * 
 * But watch out: I added some additional tests which will not pass with your current solution. 
 * 
 * Watch out for encapsulation:
 * The class variable String pattern is not used from outside, so you could make it private.
 * 
 * Watch out for naming:
 * 		return proof(String file, String pattern)
 * would be more readable/understandable if you use for example
 * 		return isFilenameMatchingPattern(String filename, String pattern)
 * 
 * A better name for the counter variable in the proof method could be patternPosition because you use the counter
 * for getting a char out of the pattern at a specific position. Same for i which could be filenamePosition.
 * Don't be afraid of using long method or variable names as long as they are descriptive.
 * 
 * STATUS: accepted (ok)
 */
public class FilePattern implements FileFilter {
	/**
	 * Creates a new instance of the FilePattern class that filters
	 * file names based on the given pattern.
	 * 
	 * @param pattern the pattern used to filter file names.
	 * @see FilePattern
	 */
	String pattern;
	public FilePattern(String pattern) {
		this.pattern=pattern;
	}

	public boolean accept(File pathname) {
		return proof(pathname.toString(),pattern);
	}

	private boolean proof(String file, String pattern){
		int counter = 0;

		for (int i = 0; i < file.length(); i++) {
			if (counter > pattern.length() - 1) {
				return false;
			}

			//If char not match
			if (file.charAt(i) != pattern.charAt(counter)) {
				//case *
				if (pattern.charAt(counter) == '*') {
					//at the end
					if (counter + 1 >= pattern.length()) {
						return true;
					}
					//in text
					if (pattern.charAt(counter + 1) == file.charAt(i)) {
						if(proof(pattern.substring(counter + 1),file.substring(i))){
							return true;
						}
					}
				}
				//case ?
				else if (pattern.charAt(counter) == '?') {
					//if its the las char
					if (counter == pattern.length() - 1) {
						if (i < file.length() - 1) {
							return false;
						}
					}
					counter++;
				} else return false;
			} else counter++;
		}

		//if * is last char and filename is longer
		if (counter == pattern.length() - 1) {
			if (pattern.charAt(counter) == '*') {
				return true;
			}
		}
		return counter > pattern.length() - 1;
	}
}
