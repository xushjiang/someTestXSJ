package xu.sheng.jiang.operation;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WebServicePublish {

	@WebMethod(operationName = "differentFromMethodName")
	public String getDate() throws Exception {

		return "tody is " + new Date();
	}
}
