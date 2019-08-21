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

	private Media paper;
	private WritingUtinsil pencil;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		paper = new Paper();
		pencil = new Pencil();
	}

	@Test
	void testPencilWriteToMedia() {
		
		String expected = "She sells sea shells";
		
		paper = pencil.write(paper, "She sells sea shells");		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "TestPencilWriteToMedia Failed");
	}
	
	@Test
	void testPencilWriteToMedia2() {
				
		String expected = "This is a test 2.";
		
		paper = pencil.write(paper, "This is a test 2.");		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "TestPencilWriteToMedia2 Failed");
	}	

}
