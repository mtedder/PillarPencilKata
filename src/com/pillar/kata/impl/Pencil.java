/**
 * 
 */
package com.pillar.kata.impl;

import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pillar.kata.interfaces.Media;
import com.pillar.kata.interfaces.WritingUtinsil;

/**
 * @author Maurice Tedder
 * August 21, 2019
 */
public class Pencil implements WritingUtinsil {

	private static final int LOWER_CASE_COST = 1;
	private static final int UPPER_CASE_COST = 2;
	private static final char NO_POINT_CHAR = ' ';
	private int length;

	
	/**
	 * 
	 */
	public Pencil() {
		super();
		this.pointDurabilityCount = 0;
	}

	/*
	 * 
	 */
	public Pencil(int length, int durability) {
		this.length = length;
		this.pointDurability = durability;
		this.pointDurabilityCount = 0;
	}

	//for testing code snippets
	public static void main(String[] args) {
		String content = "testYZ";
		Pattern p = Pattern.compile("[a-z&&[^\\s]]");// or \p{Lower}
		Matcher mLower = p.matcher(content);
//		int lowerCaseCount = 0;
//		while(m.find()) {
//			lowerCaseCount++;
//		}
		int pointDurability = 4;
		for(int i=0; i < content.length(); i++) {
			boolean isMatch = mLower.find(i);
			int letterCost = 0;
			if(isMatch) {//lowecase
				letterCost = LOWER_CASE_COST;
			}else {//non-lowercase
				letterCost = UPPER_CASE_COST;
			}
			
			if(pointDurability >= letterCost) {
				System.out.println(String.valueOf(content.charAt(i)));
			}else {//not enough pointDurability - print space
				System.out.println("*");
			}
			
			pointDurability -= letterCost;
			//System.out.println(isMatch + ":" + content.charAt(i));
		}
		
		//String tempContent = content.substring(0, lowerCaseCount);
		
		
	}
	
	/*
	 * durability of pencil point as it writes- lowercase = -1, uppercase = -2
	 */
	private int pointDurability=Integer.MAX_VALUE;
	private int pointDurabilityCount;

	@Override
	public Media write(Media paper, String content) {
				
		//print only number of characters equal to pointDurability remaining and fill the remaining length 
		//with spaces
		//ref: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
//		https://programming.guide/java/number-of-regex-matches.html
		//Lower case count - ignore space & punctuation
		Pattern pLower = Pattern.compile("[a-z&&[^\\s]]");// or \p{Lower}
		Matcher mLower = pLower.matcher(content);
		
		//Upper case count - ignore space & punctuation
		Pattern pUpper = Pattern.compile("[A-Z&&[^\\s]]");// or \p{Upper}
		Matcher mUpper = pUpper.matcher(content);
		
		//Spaces in content/input count
		Pattern pSpace = Pattern.compile("\\s");//
		Matcher mSpace = pSpace.matcher(content);

		
		//numbers & punctuation in content/input count
		Pattern pNonLtrs = Pattern.compile("[\\p{Digit}\\p{Punct}]");//
		Matcher mNonLtrs = pNonLtrs.matcher(content);
			
		char output;
//		for(int i=0; i < content.length(); i++) {
		for(char ch: content.toCharArray()) {
//			boolean isMatch = mLower.find(i);
//			boolean isSpaceMatch = mSpace.find(i);
			boolean isMatch = Pattern.matches("[a-z&&[^\\s]]", String.valueOf(ch));
			boolean isSpaceMatch  = Pattern.matches("\\s",  String.valueOf(ch));
			
			pointDurabilityCount = 0;
			if(isMatch) {//lowecase
				pointDurabilityCount += LOWER_CASE_COST;
			}else if(isSpaceMatch){//space of newline
				//use default
			}else {//non-lowercase or non-space or non-newline
				pointDurabilityCount += UPPER_CASE_COST;
			}
			
			if(pointDurability >= pointDurabilityCount) {
				output = ch;
			}else {//not enough pointDurability - print space
				output = NO_POINT_CHAR;
			}
			
			pointDurability -= pointDurabilityCount;
			paper.setContent(String.valueOf(output));
		}
		return paper;
	}

	@Override
	public void setPointDurability(int pointDurability) {
		this.pointDurability = pointDurability;
	}

	@Override
	public int getPointDurability() {
		int result = pointDurability - pointDurabilityCount;
		return result;
	}

	@Override
	public void sharpen() {
		length--;
		pointDurabilityCount= 0;//restore durability
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the pointDurabilityCount
	 */
	public int getPointDurabilityCount() {
		return pointDurabilityCount;
	}

	/**
	 * @param pointDurabilityCount the pointDurabilityCount to set
	 */
	public void setPointDurabilityCount(int pointDurabilityCount) {
		this.pointDurabilityCount = pointDurabilityCount;
	}
		
}
