package com.bitcamp.networking.url;


import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class SocketConnector {
	
	// umjesto 127.0.0.1. moze i localHost
	public static final String serverAdress = "127.0.0.1";
	// port mora biti isti ako i kod servera!!
	public static final int port = 1728;
	public  static Socket client;

	/**
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private static void connectToServer() throws UnknownHostException,
			IOException {

		client = new Socket(serverAdress, port);
		// InputStream prima poruke sa servera
		InputStream clientInt = client.getInputStream();
		readMessage(clientInt);
		// OutputStream salje poruke serveru
		OutputStream clientOut = client.getOutputStream();
		sendMessage(clientOut);
	

	}

	public static void sendMessage(OutputStream clientOut) throws IOException {
		
		
		String msg = "Hello from Client";
		
		byte[] msgByte = msg.getBytes();
		
		clientOut.write(msgByte.length);

		clientOut.write(msgByte);

	

	}

	public static void readMessage(InputStream clientInt) throws IOException {

		int msgLength = clientInt.read();
		byte[] buffer = new byte[msgLength];
		int byteRead = 0;
		// povecamo byteRead svaki put kada procitamo byte
		StringBuilder sb = new StringBuilder();

		while ((byteRead += clientInt.read(buffer)) >= 0) {
			sb.append(new String(buffer).replaceAll("\\s+", " "));
			if (byteRead >= msgLength)
				break;

		}
		String bufferString = sb.toString();
		System.out.println(bufferString);

	}

	public static void main(String[] args) {
		try {
			connectToServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
