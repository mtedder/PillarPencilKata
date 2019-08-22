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

	/*
	 * As a pencil manufacturer I want writing to cause a pencil point to go dull so
	 * that I can sell more pencils
	 * 
	 * When a pencil is created, it can be provided with a value for point
	 * durability. The pencil will be able to write only a limited number of
	 * characters before it goes dull. After it goes dull, every character it is
	 * directed to write will appear as a space. A pencil created with a high point
	 * durability will still go dull, but not as fast as one with a lower durability
	 * rating.
	 * 
	 * Writing spaces and newlines expends no graphite, therefore "writing" these
	 * characters should not affect the pencil point.
	 * 
	 * Lowercase letters should degrade the pencil point by a value of one, and
	 * capital letters should degrade the point by two. Hence when a pencil with a
	 * point durability of four is instructed to write the string "text", the paper
	 * will contain the entire string. But if a pencil with point durability of four
	 * is instructed to write the string "Text", the paper will only show "Tex ".
	 */
	void setPointDurability(int i);

}
