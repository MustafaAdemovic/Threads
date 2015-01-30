package com.bitcamp.thread;

import java.util.ArrayList;

public class WriteRanodmHash implements Runnable {
	private String name;

	public WriteRanodmHash(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		ArrayList<String> strings = new ArrayList<String>();

		strings.add("Ado");
		strings.add("Samir");
		strings.add("Hike");
		strings.add("Emina");
		strings.add("Edib");
		for (String s : strings) {
			System.out.println(s);
		}

	}

}
