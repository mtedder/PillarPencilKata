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
class WritingUtinsilEditingTest {

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
	void testPencilEditingInsertCase() {
		String expected = "An onion a day keeps the doctor away";		
		
		paper = new Paper();
		pencil = new Pencil();
		
		pencil.setEraseDurability(100);
		
		paper = pencil.write(paper, "An       a day keeps the doctor away");//add content
		
		paper = pencil.edit(paper, "onion");	
		String actual = paper.getContent();
		
		assertEquals(expected, actual, "testPencilEditingInsertCase Failed");
	}
	
	@Test
	void testPencilEditingInsertAndReplaceCase() {
		String expected = "An artich@k@ay keeps the doctor away";		
		
		paper = new Paper();
		pencil = new Pencil();
		
		pencil.setEraseDurability(100);
		
		paper = pencil.write(paper, "An       a day keeps the doctor away");//add content
		
		paper = pencil.edit(paper, "artichoke");	
		String actual = paper.getContent();
		
		assertEquals(expected, actual, "testPencilEditingInsertAndReplaceCase Failed");
	}	

}
