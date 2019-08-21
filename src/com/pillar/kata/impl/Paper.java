/**
 * 
 */
package com.pillar.kata.impl;

import com.pillar.kata.interfaces.Media;

/**
 * @author Maurice Tedder
 * August 21, 2019
 *
 */
public class Paper implements Media {

	private String content;

	@Override
	public String getContent() {
		return this.content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;	
	}

}
