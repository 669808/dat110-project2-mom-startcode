package no.hvl.dat110.iotsystem;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.broker.ClientSession;
import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.ConnectMsg;
import no.hvl.dat110.messages.CreateTopicMsg;
import no.hvl.dat110.messages.DisconnectMsg;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.MessageUtils;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.messages.SubscribeMsg;
import no.hvl.dat110.messages.UnsubscribeMsg;
import no.hvl.dat110.messagetransport.Connection;
import no.hvl.dat110.messagetransport.MessageConfig;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		System.out.println("Display starting ...");

		// TODO - START
		// create a client object and use it to
		// - connect to the broker - use "display" as the username
		String user = "display";
		String topic = "temperature";
		Client client = new Client(user, MessageConfig.MESSAGINGHOST, MessageConfig.MESSAGINGPORT);
		client.connect();
		// - create the temperature topic on the broker
		client.createTopic(topic);
		// - subscribe to the topic
		client.subscribe(topic);
		// - receive messages on the topic
		for(int i = 0; i < COUNT; i++) {
			client.receive();
		}
		// - unsubscribe from the topic
		client.unsubscribe(topic);
		// - disconnect from the broker
		client.disconnect();
		// TODO - END

		System.out.println("Display stopping ... ");
	}
}
