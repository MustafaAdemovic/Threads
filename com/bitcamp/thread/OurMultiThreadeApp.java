package com.bitcamp.thread;

public class OurMultiThreadeApp {

	public static void main(String[] args) {
		WriteIntegers wi = new WriteIntegers("Integers");
		WriteStrings ws = new WriteStrings("String");
		WriteRanodmHash wrh = new WriteRanodmHash("Hash");
		Thread t = new Thread(wrh);
		t.start();
		wi.start();
		ws.start();

	}

}
