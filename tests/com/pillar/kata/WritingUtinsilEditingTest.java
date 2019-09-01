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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPencilEditingInsertCase() {
		String expected = "An onion a day keeps the doctor away";		
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		pencil.setEraseDurability(100);
		
		paper = pencil.write(paper, "An       a day keeps the doctor away");//add content
		
		paper = pencil.edit(paper, "onion");	
		String actual = paper.getContent();
		
		assertEquals(expected, actual, "testPencilEditingBreakEvenCase Failed");
	}

}
