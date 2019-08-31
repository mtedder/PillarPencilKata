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
	
	int getPointDurability();
	
	
	/*
	 * As a writer I want to be able to sharpen my pencil so that I can continue to
	 * write with it after it goes dull
	 * 
	 * When a pencil is sharpened, it regains its initial point durability and can
	 * write more characters before it goes dull again. Thus, given a pencil created
	 * with point durability of 40,000 that has since degraded, when it is
	 * sharpened, its point durability will be 40,000 again.
	 * 
	 * A pencil should also be created with an initial length value. Pencils of
	 * short length will only be sharpenable a small number of times while pencils
	 * of longer length can be sharpened more times. The pencil's length is reduced
	 * by one each time it is sharpened. When a pencil's length is zero, then
	 * sharpening it no longer restores its point durabliity.
	 */	
	void sharpen();
	
	int getLength();

	/*
	 * As a writer I want to be able to erase previously written text so that I can
	 * remove my mistakes
	 * 
	 * When the pencil is instructed to erase text from the paper, the last
	 * occurrence of that text on the paper will be replaced with empty spaces.
	 * 
	 * Given a piece of the paper containing the string:
	 * "How much wood would a woodchuck chuck if a woodchuck could chuck wood?" when
	 * the string "chuck" is erased, the paper should read:
	 * "How much wood would a woodchuck chuck if a woodchuck could       wood?" and
	 * if the string "chuck" is erased again, the paper should read:
	 * "How much wood would a woodchuck chuck if a wood      could       wood?"
	 */
	Media erase(Media paper, String string);

	/*
	 * As a pencil manufacturer I want a pencil eraser to eventually wear out so
	 * that I can sell more pencils
	 * 
	 * When a pencil is created, it can be provided with a value for eraser
	 * durability. For simplicity, all characters except for white space should
	 * degrade the eraser by a value of one. Text should be erased in the opposite
	 * order it was written. Once the eraser durability is zero, the eraser is worn
	 * out and can no longer erase.
	 * 
	 * Thus if a pencil's eraser has remaining durability of three, and it is
	 * instructed to erase the word "Bill" from "Buffalo Bill", then the text
	 * remaining on the paper is "Buffalo B   ".
	 */	
	void setEraseDurability(int i);
	
	

}
