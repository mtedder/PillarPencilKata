/**
 * 
 */
package main.java.com.pillar.kata.impl;

import main.java.com.pillar.kata.interfaces.Media;

/**
 * @author Maurice Tedder
 * August 21, 2019
 *
 */
public class Paper implements Media {

	/*
	 * Not using a String builder because there's is no
	 * requirement for thread synchronization as in a collaboration type application.
	 */
	private StringBuffer content;
		
	/*
	 * Default constructor to create the StringBuffer object
	 */
	public Paper() {
		super();
		this.content = new StringBuffer();
	}

	@Override
	public String getContent() {
		return this.content.toString();
	}

	@Override
	public void setContent(String content) {
		this.content.append(content);	
	}

}
