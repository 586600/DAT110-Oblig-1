package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		// Ferdig
		
		rpcclient.connect();
		
		byte[] bytesSende = RPCUtils.marshallInteger(RPCID, 0); 
		byte [] bytesMottat = rpcclient.call(bytesSende);
		
		temp = RPCUtils.unmarshallInteger(bytesMottat);
		
		return temp;
	}
	
}
