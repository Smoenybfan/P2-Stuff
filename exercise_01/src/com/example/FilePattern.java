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
 * @author You!
 *
 */
public class FilePattern implements FileFilter {

	/**
	 * Creates a new instance of the FilePattern class that filters
	 * file names based on the given pattern.
	 * 
	 * @param pattern the pattern used to filter file names.
	 * @see FilePattern
	 */
	public FilePattern(String pattern) {
		// TODO add your solution here
	}

	public boolean accept(File pathname) {
		// TODO add your solution here
		throw new Error();
	}
    
}
