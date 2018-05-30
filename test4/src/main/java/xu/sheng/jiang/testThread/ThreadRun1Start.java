package xu.sheng.jiang.testThread;

/**
 * 创建没有返回值的线程
 * 
 * @author xushjiang
 *
 */
public class ThreadRun1Start {

	public static void main(String[] args) {

		ThreadRun1 threadRun = new ThreadRun1();// 创建功能实现类实例
		Thread thread = new Thread(threadRun);// 创建线程实例
		thread.start();// 启动线程
	}

}
