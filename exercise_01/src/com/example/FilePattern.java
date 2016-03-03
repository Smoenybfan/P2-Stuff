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
	String pattern;
	public FilePattern(String pattern) {
		this.pattern=pattern;
	}

	public boolean accept(File pathname1) {
		String pathname=pathname1.getPath();
		int patterncounter = 0;
		int i=0;
		while((pathname.charAt(i)==pattern.charAt(patterncounter) || pattern.charAt(patterncounter)=='?')&&i<pathname.length()-1&&patterncounter<pattern.length()-1){
			i++;
			patterncounter++;
		}
		while(pattern.charAt(patterncounter)=='*'){
			while(pattern.charAt(patterncounter+1)!=pathname.charAt(i)){
				i++;
			}
			patterncounter++;
		}

		if(i==pathname.length()-1 || patterncounter==pattern.length()-1){
			return true;
		}

		throw new Error();

	}
    
}
