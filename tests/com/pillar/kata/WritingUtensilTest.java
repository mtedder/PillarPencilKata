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
	void testPencilWriteToMediaWithNonLetters() {
				
		String expected = "This is a test 2.";
		
		paper = pencil.write(paper, "This is a test 2.");		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "TestPencilWriteToMedia2 Failed");
	}
	
	@Test
	void testPencilWriteAppendToMedia() {
				
		String expected = "She sells sea shells down by the sea shore";
		
		paper = pencil.write(paper, "She sells sea shells");	
		paper = pencil.write(paper, " down by the sea shore");		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "TestPencilWriteToMedia2 Failed");
	}
	
	@Test
	void testPencilWritePointDurabilityBreakEvenLowerCase() {
				
		String expected = "test";
		
		pencil.setPointDurability(4);
		
		paper = pencil.write(paper, "test");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilityBreakEvenLowerCase Failed");
	}
	
	@Test
	void testPencilWritePointDurabilityDeficitLowerCase() {
				
		String expected = "tes ";
		
		pencil.setPointDurability(3);
		
		paper = pencil.write(paper, "test");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilityDeficitLowerCase Failed");
	}
	
	/*
	 * This test is also covered in the testPencilWriteAppendToMedia case
	 * but added here for robustness.
	 */
	@Test
	void testPencilWritePointDurabilitySurplusLowerCase() {
				
		String expected = "testing";
		
		pencil.setPointDurability(100);
		
		paper = pencil.write(paper, "testing");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilitySurplusLowerCase Failed");
	}	

	@Test
	void testPencilWritePointDurabilityBreakEvenUpperCase() {
				
		String expected = "TEST";
		
		pencil.setPointDurability(8);
		
		paper = pencil.write(paper, "TEST");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilityBreakEvenUpperCase Failed");
	}
}
