package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		
		if (payload.length < MessageConfig.SEGMENTSIZE) {
			
		this.payload = payload; // TODO: check for length within boundary
		
		}
	}

	public Message() {
		
		super();
	}

	public byte[] getData() {
		
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		// Ferdig
		
		byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];
		Integer lengthPayload = payload.length;
		encoded[0] = lengthPayload.byteValue();
		
		for (int i = 0; i < payload.length; i++) {
			
			encoded[i+1] = payload[i];
		}
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {
		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		// Ferdig
		
		this.payload = new byte[received[0]];
		
    	for (int i = 0; i < received[0]; i++) {
    		
    		this.payload[i] = received[i+1];
    	}	
	}
}