package test.testThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadRun1 implements Runnable {

	@Override
	public void run() {

		System.out.println(new SimpleDateFormat().format(new Date()));

	}

}
