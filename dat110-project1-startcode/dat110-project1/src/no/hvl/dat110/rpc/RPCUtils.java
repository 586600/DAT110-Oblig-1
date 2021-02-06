package no.hvl.dat110.rpc;

import java.util.Arrays;

import java.nio.ByteBuffer;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		
		// Ferdig

		encoded = new byte[str.getBytes().length + 1];
		
		encoded[0] = rpcid;
		
		byte[] string = str.getBytes();
		
		for (int i = 1; i < encoded.length; i++) {
			
			encoded[i] = string[i - 1];
					
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded
		
		// Ferdig

		decoded = new String(Arrays.copyOfRange(data, 1, data.length));

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type
		
		// Ferdig

		encoded = new byte[1];
		
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
		// Ferdig
		
		return;
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		
		// Ferdig

		encoded = new byte[5];
		
		encoded[0] = rpcid;
		
		byte[] byteTabell = ByteBuffer.allocate(4).putInt(x).array();
		
		for (int i = 1; i < encoded.length; i++) {
			
			encoded[i] = byteTabell[i - 1];
			
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		
		// Ferdig

		decoded = ByteBuffer.wrap(Arrays.copyOfRange(data, 1, data.length)).getInt();

		return decoded;

	}
}
