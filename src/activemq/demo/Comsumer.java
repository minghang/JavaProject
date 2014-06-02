package activemq.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Comsumer {

	public static void main(String[] args) {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = null;
		Session session = null;
		
		Destination destination = null;
		
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			while (true) {
				destination = session.createTopic("test");
				MessageConsumer messageConsumer = session.createConsumer(destination);
				messageConsumer.setMessageListener(new Listener());
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class Listener implements MessageListener {
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String strMessage = textMessage.getText();
			System.out.println("Consumer " + strMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
