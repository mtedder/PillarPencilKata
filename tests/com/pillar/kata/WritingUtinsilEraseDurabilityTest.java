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
				
		assertEquals(expected, actual, "testPencilEraseDurabilitySurplusEvenLowerCase Failed");
	}	

}
