package xu.sheng.jiang.test;

import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;

@javax.jws.WebService
public class WebService {

	public static void main(String[] args) {

		Endpoint.publish("http://192.168.1.236/wenService", new WebService());

	}

	@WebMethod
	public String getName(String name) throws Exception {

		return "hello:" + name;
	}


}
