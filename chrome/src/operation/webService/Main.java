package operation.webService;

import javax.xml.ws.Endpoint;

/**
 * 发布webService服务
 * 
 * @author xushjiang
 *
 */
public class Main {

	public static void main(String[] args) {

		WebServiceInteface ws = new WebServiceIntefaceImpl();

		// 发布
		Endpoint.publish("http://192.168.1.236:8091/", ws);

	}

}
