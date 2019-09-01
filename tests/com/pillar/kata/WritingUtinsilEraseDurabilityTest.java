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
 *
 */
class WritingUtinsilEraseDurabilityTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPencilEraseDurabilityBreakEvenLowerCase() {
		
		String expected = "    ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		paper = pencil.write(paper, "test");//add content
		
		paper = pencil.erase(paper, "test");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilEraseDurabilityBreakEvenLowerCase Failed");
	}
	
	@Test
	void testPencilEraseDurabilityDeficitLowerAndUpperCase() {
		
		String expected = "Buffalo B   ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(3);
		
		paper = pencil.write(paper, "Buffalo Bill");//add content
		
		paper = pencil.erase(paper, "Bill");	
		String actual = paper.getContent();	
		
		int expectedEraseDurability = 0;
		int actualEraseDurability = pencil.getEraseDurability();
				
		assertEquals(expected, actual, "testPencilEraseDurabilitySurplusEvenLowerCase #a Failed");
		assertEquals(expectedEraseDurability, actualEraseDurability, "testPencilEraseDurabilitySurplusEvenLowerCase #b Failed");
	}
	
	@Test
	void testPencilEraseDurabilityBreakEvenLowerAndUpperCase() {
		
		String expected = "Buffalo     ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(4);
		
		paper = pencil.write(paper, "Buffalo Bill");//add content
		
		paper = pencil.erase(paper, "Bill");	
		String actual = paper.getContent();	
		
		int expectedEraseDurability = 0;
		int actualEraseDurability = pencil.getEraseDurability();
				
		assertEquals(expected, actual, "testPencilEraseDurabilitySurplusEvenLowerCase #a Failed");
		assertEquals(expectedEraseDurability, actualEraseDurability, "testPencilEraseDurabilitySurplusEvenLowerCase #b Failed");
	}
	
	@Test
	void testPencilEraseDurabilitySurplusLowerAndUpperCase() {
		
		String expected = "Buffalo     ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(100);
		
		paper = pencil.write(paper, "Buffalo Bill");//add content
		
		paper = pencil.erase(paper, "Bill");	
		String actual = paper.getContent();	
		
		int expectedEraseDurability = 96;
		int actualEraseDurability = pencil.getEraseDurability();
				
		assertEquals(expected, actual, "testPencilEraseDurabilitySurplusEvenLowerCase #a Failed");
		assertEquals(expectedEraseDurability, actualEraseDurability, "testPencilEraseDurabilitySurplusEvenLowerCase #b Failed");
	}	
	
	@Test
	void testPencilEraseDurabilityBreakEvenTwoWordsLowerAndUpperCase() {
		
		String expected = "Buffalo          ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(8);
		
		paper = pencil.write(paper, "Buffalo Wild Bill");//add content
		
		paper = pencil.erase(paper, "Bill");
		paper = pencil.erase(paper, "Wild");
		String actual = paper.getContent();	
		
		int expectedEraseDurability = 0;
		int actualEraseDurability = pencil.getEraseDurability();
				
		assertEquals(expected, actual, "testPencilEraseDurabilityBreakEvenTwoWordsLowerAndUpperCase #a Failed");
		assertEquals(expectedEraseDurability, actualEraseDurability, "testPencilEraseDurabilityBreakEvenTwoWordsLowerAndUpperCase #b Failed");
	}
	
	@Test
	void testPencilEraseDurabilityDeficitTwoWordsLowerAndUpperCase() {
		
		String expected = "Buffalo Wil      ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(5);
		
		paper = pencil.write(paper, "Buffalo Wild Bill");//add content
		
		paper = pencil.erase(paper, "Bill");
		paper = pencil.erase(paper, "Wild");
		String actual = paper.getContent();	
		
		int expectedEraseDurability = 0;
		int actualEraseDurability = pencil.getEraseDurability();
				
		assertEquals(expected, actual, "testPencilEraseDurabilityDeficitTwoWordsLowerAndUpperCase #a Failed");
		assertEquals(expectedEraseDurability, actualEraseDurability, "testPencilEraseDurabilityDeficitTwoWordsLowerAndUpperCase #b Failed");
	}
	
	@Test
	void testPencilEraseDurabilitySurplusTwoWordsLowerAndUpperCase() {
		
		String expected = "Buffalo          ";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(100);
		
		paper = pencil.write(paper, "Buffalo Wild Bill");//add content
		
		paper = pencil.erase(paper, "Bill");
		paper = pencil.erase(paper, "Wild");
		String actual = paper.getContent();	
		
		int expectedEraseDurability = 92;
		int actualEraseDurability = pencil.getEraseDurability();
				
		assertEquals(expected, actual, "testPencilEraseDurabilitySurplusTwoWordsLowerAndUpperCase #a Failed");
		assertEquals(expectedEraseDurability, actualEraseDurability, "testPencilEraseDurabilitySurplusTwoWordsLowerAndUpperCase #b Failed");
	}	

}
