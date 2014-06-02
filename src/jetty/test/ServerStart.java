package jetty.test;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;


public class ServerStart {
	public static void main(String[] args) throws Exception {
		Server server = new Server();// 定义一个server
		// 定义一个连接器
		Connector connector = new SelectChannelConnector();
		connector.setPort(8080);
		// 此处不解释，应该都能猜到
		server.setConnectors(new Connector[] { connector });

		// 定义上下文
		WebAppContext webapp = new WebAppContext();
		// 此处的/JettyDemo此处为访问该web项目时候，localhost:8080/项目名称中的项目名称的位
		// 置，可以自定义。
		webapp.setContextPath("/JettyDemo");
		webapp.setWar("./WebRoot");
		// 这个是默认的web.xml配置
		webapp.setDefaultsDescriptor("etc/webdefault.xml");
		server.setStopAtShutdown(true);

		server.setHandler(webapp);
		// 启动server
		server.start();
	}
}
