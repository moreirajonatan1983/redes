/**
 * 
 */
package org.utnfrd.chat.swing;

import org.utnfrd.chat.main.ChatConstant;

/**
 * @author jonatan.moreira
 *
 */
public class Chat {

	
	public static void main(String[] args) {

		ChatEmulator chatClient0 = new ChatEmulator(ChatConstant.tcpFromIP, ChatConstant.tcpFromPort, ChatConstant.tcpToIP , ChatConstant.tcpToPort, "Jonatan", "Ana");
		chatClient0.setVisible(true);		

		ChatEmulator chatClient00 = new ChatEmulator(ChatConstant.tcpFromIP, ChatConstant.tcpFromPort, ChatConstant.tcpToIP , ChatConstant.tcpToPort, "Ana", "Jonatan");
		chatClient00.setVisible(true);		
		
		
//		ChatEmulator chatClient1 = new ChatEmulator("127.0.0.1" , 9876, "127.0.0.1" , 9878, "Jonatan", "Ana");
//		chatClient1.setVisible(true);
//
//		ChatEmulator chatClient2 = new ChatEmulator("127.0.0.1" , 9878, "127.0.0.1" , 9876,"Ana", "Jonatan");
//		chatClient2.setVisible(true);

//		ChatClient chatClient3 = new ChatClient("127.0.0.1" , 9876, "127.0.0.1" , 9876,"Ana", "Felipe");
//		chatClient3.setVisible(true);		
		
	}
	
}
