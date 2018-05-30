package xu.sheng.jiang.testThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 实现callable接口实现有返回值的多线程
 * 
 * @author xushjiang
 *
 */
public class MyThread1 implements Callable<Object> {

	private String str = "实现有返回值的多线程";

	/**
	 * 创建一个带参的构造方法
	 */
	public MyThread1(String str) {
		this.str = str;
	}

	public MyThread1() {
	}

	/**
	 * 启动线程是，将启动此方法
	 */
	@Override
	public Object call() throws Exception {

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");
		String date_str = df.format(date);
		return date_str + str;
	}

}
