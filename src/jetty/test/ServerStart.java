package jetty.test;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;


public class ServerStart {
	public static void main(String[] args) throws Exception {
		Server server = new Server();// ����һ��server
		// ����һ��������
		Connector connector = new SelectChannelConnector();
		connector.setPort(8080);
		// �˴������ͣ�Ӧ�ö��ܲµ�
		server.setConnectors(new Connector[] { connector });

		// ����������
		WebAppContext webapp = new WebAppContext();
		// �˴���/JettyDemo�˴�Ϊ���ʸ�web��Ŀʱ��localhost:8080/��Ŀ�����е���Ŀ���Ƶ�λ
		// �ã������Զ��塣
		webapp.setContextPath("/JettyDemo");
		webapp.setWar("./WebRoot");
		// �����Ĭ�ϵ�web.xml����
		webapp.setDefaultsDescriptor("etc/webdefault.xml");
		server.setStopAtShutdown(true);

		server.setHandler(webapp);
		// ����server
		server.start();
	}
}
