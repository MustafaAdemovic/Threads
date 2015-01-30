package com.bitcamp.thread;

public class WriteIntegers extends Thread {
	private String name;

	public WriteIntegers(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " ");
		}
	}
}
