package no.hvl.dat110.iotsystem;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.broker.ClientSession;
import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;
import no.hvl.dat110.messages.ConnectMsg;
import no.hvl.dat110.messages.DisconnectMsg;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.messagetransport.Connection;
import no.hvl.dat110.messagetransport.MessageConfig;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();
		// TODO - start
		// create a client object and use it to
		// - connect to the broker - user "sensor" as the user name
		String user = "sensor";
		String topic = "temperature";
		Client client = new Client(user, MessageConfig.MESSAGINGHOST, MessageConfig.MESSAGINGPORT);
		client.connect();
		// - publish the temperature(s)
		for(int i = 0; i < COUNT; i++) {
			client.publish(topic, "" + sn.read());
		}
		// - disconnect from the broker
		client.disconnect();
		// TODO - end

		System.out.println("Temperature device stopping ... ");
	}
}
