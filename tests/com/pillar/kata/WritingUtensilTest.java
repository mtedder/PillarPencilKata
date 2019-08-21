/**
 * 
 */
package com.pillar.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pillar.kata.impl.Paper;
import com.pillar.kata.impl.Pencil;
import com.pillar.kata.interfaces.Media;
import com.pillar.kata.interfaces.WritingUtinsil;

/**
 * @author Maurice Tedder
 * August 21, 2019
 *
 */
class WritingUtensilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPencilWriteToMedia() {
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		String expected = "This is a test 1.";
		
		paper = pencil.write(paper, "This is a test 1.");		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "TestPencilWriteToMedia Failed");
	}
	
	@Test
	void testPencilWriteToMedia2() {
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		String expected = "This is a test 2.";
		
		paper = pencil.write(paper, "This is a test 2.");		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "TestPencilWriteToMedia2 Failed");
	}	

}