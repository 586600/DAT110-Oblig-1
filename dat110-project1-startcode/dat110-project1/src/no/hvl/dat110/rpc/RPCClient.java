package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		
		// TODO: connect using the underlying messaging layer connection
		
		// Ferdig
		
		if (connection == null) {
			
			try {
				
				connection = msgclient.connect();
				
			} catch (Exception e) {
				
				System.out.println("Det oppstod en feil " + e);
				
			}
			
			
		}
			
	}
	
	public void disconnect() {
		
		// TODO: disconnect/close the underlying messaging connection
		
		// Ferdig
		
		try {
			
			if (connection != null) {
				
				connection.close();
			}
			
		} catch (Exception e) {
			
			System.out.println("Det oppstod en feil " + e);
		}
		
		
		
		
	}
	
	public byte[] call(byte[] rpcrequest) {
		
		byte[] rpcreply;
		
		/* TODO: 
		
		Make a remote call on the RPC server by sending the RPC request message
		and receive an RPC reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		
		// Ferdig
		
		
		Message requestMessage = new Message(rpcrequest);
		
		connection.send(requestMessage);
		
		Message receiveMessage = connection.receive();
		
		rpcreply = receiveMessage.getData();
		
		return rpcreply;
		
	}

}
