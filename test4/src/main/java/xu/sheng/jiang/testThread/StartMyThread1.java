package xu.sheng.jiang.testThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 启动线程MyThread1
 * 
 * @author xushjiang
 *
 */
public class StartMyThread1 extends MyThread1 {

	private final static String str = "启动线程";
	private static StringBuffer strBuf;
	public static void main(String[] args) {

		Callable<Object> myThread = new MyThread1(str);// 创建线程实例

		ExecutorService pool = Executors.newFixedThreadPool(1);// 创建线程池，大小为1

		Future<Object> f = pool.submit(myThread);// 启动线程，并返回结果

		pool.shutdown();// 关闭线程池,否则线程将一直运行

		try {
			System.out.println(f.get().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("成功返回结果");
		}
	}

}
