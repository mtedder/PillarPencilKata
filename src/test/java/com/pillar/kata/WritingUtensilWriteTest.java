/**
 * 
 */
package test.java.com.pillar.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.pillar.kata.impl.Paper;
import main.java.com.pillar.kata.impl.Pencil;
import main.java.com.pillar.kata.interfaces.Media;
import main.java.com.pillar.kata.interfaces.WritingUtinsil;

/**
 * @author Maurice Tedder
 * August 21, 2019
 *
 */
class WritingUtensilWriteTest {

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
	
	@Test
	void testPencilWritePointDurabilityDeficitUpperCase() {
				
		String expected = "TES ";
		
		pencil.setPointDurability(7);
		
		paper = pencil.write(paper, "TEST");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilityDeficitLowerCase Failed");		
	}
	
	@Test
	void testPencilWritePointDurabilityDeficitUpperCaseWithSpaces() {
				
		String expected = "TE S   ";
		
		pencil.setPointDurability(7);
		
		paper = pencil.write(paper, "TE STED");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilityDeficitLowerCase Failed");		
	}
	
	@Test
	void testPencilWritePointDurabilitySurplusUpperCase() {
				
		String expected = "TESTING";
		
		pencil.setPointDurability(100);
		
		paper = pencil.write(paper, "TESTING");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilitySurplusUpperCase Failed");
	}
	
	@Test
	void testPencilWritePointDurabilityDeficitUpperLowerSpacesCase() {
				
		String expected = "This is A t   ";
		
		pencil.setPointDurability(10);
		
		paper = pencil.write(paper, "This is A test");	
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilWritePointDurabilityDeficitUpperLowerSpacesCase Failed");
	}		
}
