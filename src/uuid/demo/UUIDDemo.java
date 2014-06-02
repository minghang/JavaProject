//package uuid.demo;
//
//import java.io.FileInputStream;
//import java.util.UUID;
//
//import javax.jms.DeliveryMode;
//import javax.jms.Session;
//import javax.jms.StreamMessage;
//import javax.jms.TextMessage;
//import javax.jms.TopicConnection;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.ActiveMQTopicPublisher;
//import org.apache.activemq.ActiveMQTopicSession;
//import org.apache.activemq.command.ActiveMQTopic;
//
//public class UUIDDemo {
//
//	UUID uuid1 = UUID.randomUUID();
//	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.10.40.174:61616");  
//    TopicConnection connection = null;  
//    ActiveMQTopicSession session = null;  
//    ActiveMQTopicPublisher publisher = null;  
//    ActiveMQTopic topic = null;
//    try {  
//        connection = connectionFactory.createTopicConnection("zengjun", "zj");  
//        session = (ActiveMQTopicSession) connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  
//        topic = (ActiveMQTopic) session.createTopic("TEST.topic.zj");  
//        publisher = (ActiveMQTopicPublisher) session.createPublisher(topic);  
//        publisher.setDeliveryMode(DeliveryMode.PERSISTENT);  
//        connection.start();  
//        int flag = 2;  
//        if (flag == 1) {  
//            TextMessage messageText = session.createTextMessage();  
//            messageText.setText("tipic:" + System.currentTimeMillis());  
//            publisher.publish(messageText);  
//        } else {  
//            StreamMessage messageStream = session.createStreamMessage();  
//            FileInputStream fi = new FileInputStream("D:\\JavaXYQ.zip");  
//            byte[] btyes = new byte[fi.available()];  
//            fi.read(btyes);  
//            messageStream.writeBytes(btyes);  
//            publisher.publish(messageStream);  
//        }  
//        System.out.println("Topic��Ϣ���ͳɹ�");  
//    } catch (Exception e) {  
//        e.printStackTrace();  
//    } finally {  
//        ConnectionUtil.closeSession(session);  
//        ConnectionUtil.closeConnection(connection);  
//        ConnectionUtil.closeTopicPublisher(publisher);  
//    }  
//}
