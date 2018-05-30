package test.testThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建类内部的多线程
 * 
 * @author xushjiang
 *
 */
public class ThreadRun2 {

	public static void main(String[] args) {

		try {
			startThread();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void startThread() throws Exception {
	
		Runnable taret = new Runnable() {
			@Override
			public void run() {
				System.out.println(new SimpleDateFormat().format(new Date()));
			}
		};

		Thread thread = new Thread(taret);
		thread.start();
	}

}
