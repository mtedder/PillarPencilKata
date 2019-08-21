/**
 * 
 */
package com.pillar.kata.impl;

import com.pillar.kata.interfaces.Media;
import com.pillar.kata.interfaces.WritingUtinsil;

/**
 * @author Maurice Tedder
 * August 21, 2019
 */
public class Pencil implements WritingUtinsil {

	@Override
	public Media write(Media paper, String string) {
		// TODO Auto-generated method stub
		return new Paper();
	}

}
