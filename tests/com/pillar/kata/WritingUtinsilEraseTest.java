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
class WritingUtinsilEraseTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPencilEraseStandard() {
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		String expected = "How much wood would a woodchuck chuck if a woodchuck could       wood?";
		
		paper = pencil.write(paper, "How much wood would a woodchuck chuck if a woodchuck could chuck wood?");	
			
		paper = pencil.erase(paper, "chuck");
		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilEraseStandard Failed");
	}
	
	@Test
	void testPencilEraseSameWordTwice() {
		
		Media paper = new Paper();
		WritingUtinsil pencil = new Pencil();
		
		String expected = "How much wood would a woodchuck chuck if a wood      could       wood?";
		
		paper = pencil.write(paper, "How much wood would a woodchuck chuck if a woodchuck could chuck wood?");	
			
		paper = pencil.erase(paper, "chuck");
		paper = pencil.erase(paper, "chuck");
		
		String actual = paper.getContent();
				
		assertEquals(expected, actual, "testPencilEraseSameWordTwice Failed");
	}	

}
