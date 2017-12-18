﻿package testbooks.probSeg;

import java.util.Iterator;

import junit.framework.TestCase;

public class TestTokenList extends TestCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CnToken t1 = new CnToken(2, 3, 2.0, "见");
		CnToken t2 = new CnToken(1, 3, 3.0, "意见");
		CnTokenLinkedList tokenList = new CnTokenLinkedList();
		tokenList.put(t1);
		tokenList.put(t2);
		for(CnToken t:tokenList){
			System.out.println(t);
		}
	}
	
	public static void testItr(){
		CnToken t1 = new CnToken(2, 3, 2.0, "见");
		CnToken t2 = new CnToken(1, 3, 3.0, "意见");
		CnTokenLinkedList tokenList = new CnTokenLinkedList();
		tokenList.put(t1);
		tokenList.put(t2);
		
		Iterator<CnToken> itr = tokenList.iterator();
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
	}
}
