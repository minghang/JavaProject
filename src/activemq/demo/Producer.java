package activemq.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	public static void main(String[] args) {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		
		Destination destination = null;
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("test");
			producer = session.createProducer(destination);
			
			for (int i = 0; i < 100; i++) {
				
				Message message = session.createTextMessage(String.valueOf(i));
				producer.send(message);
				System.out.println("send " + i);
				Thread.sleep(5000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
