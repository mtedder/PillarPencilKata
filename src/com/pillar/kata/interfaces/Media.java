/**
 * 
 */
package com.pillar.kata.interfaces;

/**
 * @author Maurice Tedder
 * August 21, 2019
 *
 */
public interface Media {
	
	/*
	 * Return the content for this media type. Should probably use Template syntax here.
	 */
	String getContent();

	/*
	 * Set the internal data state for this content type.
	 */
	void setContent(String string);

}
