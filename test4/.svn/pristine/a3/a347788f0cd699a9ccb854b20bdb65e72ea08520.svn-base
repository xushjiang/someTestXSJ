package xu.sheng.jiang.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogInit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676018210453396392L;

	Logger logger = LoggerFactory.getLogger(LogInit.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		String prefix = config.getServletContext().getRealPath("/");
		String file = config.getInitParameter("log4j");
		String filePath = prefix + file;
		Properties props = new Properties();
		try {
			FileInputStream istream = new FileInputStream(filePath);
			props.load(istream);
			istream.close();
			if (logger.isDebugEnabled()) {
				String debugFile = prefix + props.getProperty("log4j.appender.D.File");// 设置debug路径
				props.setProperty("log4j.appender.D.File", debugFile);
			}

			if (logger.isInfoEnabled()) {
				String infoFile = prefix + props.getProperty("log4j.appender.I.File");// 设置info路径
				props.setProperty("log4j.appender.I.File", infoFile);
			}

			if (logger.isWarnEnabled()) {
				String warnFile = prefix + props.getProperty("log4j.appender.W.File");// 设置warn路径
				props.setProperty("log4j.appender.W.File", warnFile);
			}

			if (logger.isErrorEnabled()) {
				String errorFile = prefix + props.getProperty("log4j.appender.E.File");// 设置error路径
				props.setProperty("log4j.appender.E.File", errorFile);
			}

			PropertyConfigurator.configure(props);// 装入log4j配置信息
		} catch (IOException e) {
			logger.info("找不到log4j配置文件 [{}].", filePath);
			logger.info("忽略配置文件 [{}].", filePath);

		}

		return;

	}

}
