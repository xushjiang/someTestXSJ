package xu.sheng.jiang.aspect;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerWritter {

	public void dobefor() {

		System.out.println("yes!");
	}

	public void requestLogger(HttpServletRequest req, HttpServletResponse res) {

		String method = req.getMethod();
		Enumeration en = req.getAttributeNames();
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		System.out.println("END!");

	}

	public void currentTime() {

		System.err.println(new Date());
	}

	public void println(String name) {

		System.err.println(name);
	}

}
