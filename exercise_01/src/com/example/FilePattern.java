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

	public boolean accept(File pathname) {

		int counter = 0;

		for(int i = 0; i < pathname.getPath().length(); i++) {
			if (counter > pattern.length() - 1) {
				return false;
			}

			//If char not match
			if (pathname.getPath().charAt(i) != pattern.charAt(counter)) {
				//case *
				if (pattern.charAt(counter) == '*') {
					//at the end
					if (counter + 1 >= pattern.length()) {
						return true;
					}
					//in text
					if (pattern.charAt(counter + 1) == pathname.getPath().charAt(i)) {
						if((new FilePattern(pattern.substring(counter + 1)).accept
									(new File(pathname.getPath().substring(i))))){
							return true;
						}else counter += 2;
					}
				}
				//case ?
				else if (pattern.charAt(counter) == '?') {
					//if its the las char
					if (counter == pattern.length() - 1) {
						if (i < pathname.getPath().length() - 1) {
							return false;
						}
					}
					counter++;
				} else return false;
			} else counter++;
		}

		//if * is last char and filename is longer
		if(counter == pattern.length() - 1){
			if(pattern.charAt(counter) == '*'){
				return true;
			}
		}
		return counter > pattern.length() - 1;


		/* Simons Programm:
		while((pathname.getPath().charAt(i)== pattern.charAt(patterncounter)
				|| pattern.charAt(patterncounter)=='?') && i<pathname.length()-1 && patterncounter<pattern.length()-1){
			i++;
			patterncounter++;
		}
		while(pattern.charAt(patterncounter)=='*'){
			while(pattern.charAt(patterncounter+1)!=pathname.getPath().charAt(i)){
				i++;
			}
			patterncounter++;
		}

		if(i == pathname.length()-1 || patterncounter==pattern.length()-1){
			return true;
		}

		throw new Error();*/

	}
    
}
