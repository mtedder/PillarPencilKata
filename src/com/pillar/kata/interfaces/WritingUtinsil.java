/**
 * 
 */
package com.pillar.kata.interfaces;

/**
 * @author Maurice Tedder
 * August 21, 2019
 *
 */
public interface WritingUtinsil {

	/*
	 * As a writer I want to be able use a pencil to write text on a sheet of paper
	 * so that I can better remember my thoughts
	 * 
	 * When the pencil is instructed to write a string of text on a sheet of paper,
	 * the paper should reflect the text that was written.
	 * 
	 * Text written by the pencil should always be appended to existing text on the
	 * paper. Thus, given a piece of paper with the text "She sells sea shells",
	 * when a pencil is instructed to write " down by the sea shore" on the paper,
	 * the paper will then contain the entire string (i.e.
	 * "She sells sea shells down by the sea shore").
	 */
	Media write(Media paper, String string);

}
