package operation.webService;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * webService接口的实现
 * 
 * @author xushjiang
 *
 */
@WebService // 必须声明这是一个webServie服务
public class WebServiceIntefaceImpl implements WebServiceInteface {

	@WebMethod(operationName = "today") // 声明调用方法，也可不声明默认是方法名
	@Override
	public String getTody() throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy年M月d日 H:m:s");

		return df.format(new Date());
	}

}
