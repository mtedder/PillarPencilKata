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
	private static final int ERASE_COST = 1;
	private int length;
	
	/*
	 * durability of pencil point as it writes- lowercase = -1, uppercase = -2
	 */
	private int pointDurability=Integer.MAX_VALUE;
	private int pointDurabilityCount;
	
	private int eraseDurability;

	
	/**
	 * 
	 */
	public Pencil() {
		super();
		this.pointDurabilityCount = 0;
		this.eraseDurability = Integer.MAX_VALUE;
	}

	/*
	 * 
	 */
	public Pencil(int length, int durability) {
		this.length = length;
		this.pointDurability = durability;
		this.pointDurabilityCount = 0;
	}	

	/**
	 * @param length
	 * @param pointDurability
	 * @param pointDurabilityCount
	 * @param eraseDurability
	 */
	public Pencil(int length, int pointDurability, int pointDurabilityCount, int eraseDurability) {
		super();
		this.length = length;
		this.pointDurability = pointDurability;
		this.pointDurabilityCount = pointDurabilityCount;
		this.eraseDurability = eraseDurability;
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
		length = Math.max(0, --length);//negative values not allowed
		if(length > 0) {
			pointDurabilityCount= 0;//restore durability
		}
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
	 * @return the eraseDurability
	 */
	public int getEraseDurability() {
		return eraseDurability;
	}

	/**
	 * @param eraseDurability the eraseDurability to set
	 */
	public void setEraseDurability(int eraseDurability) {
		this.eraseDurability = eraseDurability;
	}

	/**
	 * @param pointDurabilityCount the pointDurabilityCount to set
	 */
	public void setPointDurabilityCount(int pointDurabilityCount) {
		this.pointDurabilityCount = pointDurabilityCount;
	}

	@Override
	public Media erase(Media paper, String word) {
		
		StringBuffer sb = new StringBuffer(paper.getContent());
		//Calculate erase budget
		int eraseBudget = word.length()-eraseDurability;
		
		if(eraseBudget > 0 ) {	//deficit 		
			eraseBudget = eraseDurability;
		}else {//breakeven or surplus
			//ok to erase whole word
			eraseBudget = word.length();
		}
		
		//find last occurrence of word in String
		
		int endIndex = sb.lastIndexOf(word) + (word.length()-1);//-1 to account for the index being -1 than the length
		
		int startIndex = endIndex - eraseBudget;
				
		eraseDurability -= eraseBudget * ERASE_COST;
		
		char[] replacementWord = new char[eraseBudget];
		
		Arrays.fill(replacementWord, NO_POINT_CHAR);//create replacement empty space string
		
		StringBuffer sbResult = sb.replace(startIndex+1, endIndex+1, String.valueOf(replacementWord));
		
		//Create new paper object with new content
		paper = new Paper();
		paper.setContent(sbResult.toString());
		
		return paper;
	}
		
}
