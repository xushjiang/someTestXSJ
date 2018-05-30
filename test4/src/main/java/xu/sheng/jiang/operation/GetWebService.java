package xu.sheng.jiang.operation;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class GetWebService {

	public static void getPublish() throws Exception {
		String webService = "http://192.168.1.236:8085/webServece";
		
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(webService);

		QName qname = new QName("http://operation.jiang.sheng.xu/", "getDate");
		call.setOperationName(qname);
		String result = (String) call.invoke(new Object[0]);
		System.out.println(result);
		System.out.println("???");

	}

	public static void main(String[] args) {

		try {
			getPublish();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
