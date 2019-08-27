/**
 * 
 */
package com.pillar.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pillar.kata.impl.Paper;
import com.pillar.kata.impl.Pencil;

/**
 * @author Maurice Tedder
 *
 */
class WritingUtinsilSharpen {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPencilUnSharpenStandard() {
		
		Pencil pencil = new Pencil(100, 100);//initial length & durability
		
		int expectedLength = 100;
		int expectedDurability = 50;//restored value
		
		pencil.setPointDurabilityCount(50);//depleted durability
		
		int actualLength = pencil.getLength();
		int actualDurability = pencil.getPointDurability();
				
		assertEquals(expectedLength, actualLength, "testPencilUnSharpenStandard Failed");
		assertEquals(expectedDurability, actualDurability, "testPencilUnSharpenStandard Failed");
	}

	/*
	 * Don't forget cross dependency test
	 */
}
