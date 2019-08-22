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
		paper.setContent(string);
		return paper;
	}

	@Override
	public void setPointDurability(int i) {
		// TODO Auto-generated method stub
	}

}
