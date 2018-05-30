package xu.sheng.jiang.web_client.xu.sheng.jiang.operation;

/**
 * 如果本项目发布的webservice，不要把生成的客户端代码放在本项目下，否则无法调用；
 * 此处只是演示客户端调用webservice，如果想要调用请新建项目将客户端代码放进去，在其中调用
 * 
 * @author xushjiang
 *
 */
public class MainClass {

	public static void main(String[] args) {

		WebServicePublishService service = new WebServicePublishService();
		WebServicePublish client = service.getWebServicePublishPort();
		try {
			System.err.println(client.differentFromMethodName());
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
